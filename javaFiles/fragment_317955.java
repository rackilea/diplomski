package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //TODO: remove the first array element and read it as the name of this instance
        SpringApplication.run(Application.class, args);
    }

}