package com.se325.a01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.se325.a01.model.Movie;
import com.se325.a01.service.MovieService;

public class App {
    public static void main(String[] args) {
        // Let's create the Spring context based on your app-context.xml
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"app-context.xml"});
        // Now your context is ready. All beans are initialised.
        // You can retrieve and use your MovieService
        MovieService movieService = context.getBean("movieService");

        Movie matrixMovie = new Movie("Matrix");
        movieService.create(matrixMovie);
    }
}