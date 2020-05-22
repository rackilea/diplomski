package com.app;

import com.app.services.ServicesVersionInfo;


public class App {

    public static void main(String[] args) {
        System.out.println("App services version: " + 
            ServicesVersionInfo.getVersion());
    }
}