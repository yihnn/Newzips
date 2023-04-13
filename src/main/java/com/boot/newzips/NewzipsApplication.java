package com.boot.newzips;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewzipsApplication {
   
   @Autowired
   ApplicationContext applicationContext;

   public static void main(String[] args) {
      SpringApplication.run(NewzipsApplication.class, args);
   }
   
   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
      
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      
      sessionFactory.setDataSource(dataSource);
      
      //xml파일 모두 읽어올것임
      sessionFactory.setMapperLocations(
            applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
      
      return sessionFactory.getObject();      
      
   }

}