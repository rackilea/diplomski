package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SomeClass {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args){
        System.setProperty("myProperty", "myFile.log");

        if(log.isDebugEnabled())
            log.debug("This is some debug!");
        log.info("Here's some info!");
        log.error("Some erorr happened!");
    }
}