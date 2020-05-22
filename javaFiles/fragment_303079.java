package com.ecommerce.microcommerce.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Configuration
@EnableAutoConfiguration
@ComponentScan({
                 "com.ecommerce.microcommerce.controller",
                 "com.ecommerce.microcommerce.dao"
                 "com.ecommerce.microcommerce.model"})
public class MicrocommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocommerceApplication.class, args);
    }
}