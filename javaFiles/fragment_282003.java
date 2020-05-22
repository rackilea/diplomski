package com.mkyong.ws;

import javax.jws.WebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebService(endpointInterface = "com.mkyong.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorldImpl.class);

    @Override
    public String getHelloWorldAsString() throws Exception {
        logger.entry();
        logger.info("Request received");
        logger.exit();

        final Exception exception = new Exception("What the heck happened?");
        logger.error(exception);
        throw exception;
    }
}