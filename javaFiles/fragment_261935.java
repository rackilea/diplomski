package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@SpringBootApplication
@EnableRetry
public class So38601998Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So38601998Application.class, args);
        Foo bean = context.getBean(Foo.class);
        try {
            bean.out("foo");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            bean.out("bar");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    @Bean
    public Foo foo() {
        return new Foo();
    }

    public static class Foo {

        @Retryable(include = IllegalArgumentException.class, exclude = IllegalStateException.class,
                maxAttempts = 5)
        public void out(String foo) {
            System.out.println(foo);
            if (foo.equals("foo")) {
                throw new IllegalArgumentException();
            }
            else {
                throw new IllegalStateException();
            }
        }

    }

}