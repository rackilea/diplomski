package com.stackoverflow.q2418355;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SimpleEJB {
    private static Logger logger = LoggerFactory.getLogger(SimpleEJB.class);

    public String sayHello(String name) {
        logger.debug(">> sayHello()");
        logger.debug("<< sayHello()");
        return "Hello " + name + "!!!";
    }
}