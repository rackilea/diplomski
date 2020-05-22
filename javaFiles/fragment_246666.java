package com.scotth.jettypublish.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

    @WebMethod 
    String sayHello(String name);
}