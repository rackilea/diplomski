package com.howtodoinjava.jerseydemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JerseydemoApplication extends SpringBootServletInitializer 
{
    public static void main(String[] args) 
    {
        new JerseydemoApplication().configure(new SpringApplicationBuilder    (JerseydemoApplication.class)).run(args);
    }
}