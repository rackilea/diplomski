package com.techtrip.mypackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {

    private Logger logger = LoggerFactory.getLogger(Foo.class);

    private String someString;

    private Foo() {
        super();
    }
    public void setSomeString(String someString) {
        if (logger.isDebugEnabled()){
            logger.debug(String.format("Setting someString %s", someString));
        }

        this.someString = someString;
    }
}