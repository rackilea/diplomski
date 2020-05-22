//Example TriggeringEventEvaluator impl

package com.mydomain.example;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

public class MyEvaluator implements TriggeringEventEvaluator {

    public boolean isTriggeringEvent(LoggingEvent event) { 
        return true; 
    }

}