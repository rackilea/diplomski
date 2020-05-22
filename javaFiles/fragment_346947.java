package com.myClass.customcode;

import com.worklight.server.bundle.api.WorklightConfiguration;

public class Test {
    public static String getWorklightProperty(String propertyName){
        return WorklightConfiguration.getInstance().getString(propertyName); 
    }
}