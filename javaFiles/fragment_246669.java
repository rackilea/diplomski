package com.scotth.jettypublish.ws.impl;

import javax.jws.WebService;

import com.scotth.jettypublish.ws.HelloWorld;

@WebService(endpointInterface = "com.scotth.jettypublish.ws.HelloWorld")
public class HelloWorldImplThree implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "THREE Hello " + (name == null ? "World" : name);
    }

}