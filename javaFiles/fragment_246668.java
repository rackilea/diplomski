package com.scotth.jettypublish.ws.impl;

import javax.jws.WebService;

import com.scotth.jettypublish.ws.HelloWorld;

@WebService(endpointInterface = "com.scotth.jettypublish.ws.HelloWorld")
public class HelloWorldImplTwo implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "TWO Hello " + (name == null ? "World" : name);
    }

}