package com.someCompany;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppNameServletContextListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started");   
                // do the things here 
    }
}