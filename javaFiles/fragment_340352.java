package com.acando.norolnes;

import org.apache.log4j.or.ObjectRenderer;

public class MyClassRenderer implements ObjectRenderer {

    @Override
    public String doRender(Object arg0) {
        if(arg0 instanceof MyClass) {
            MyClass m = (MyClass)arg0;
            return "("+m.foo+" "+m.bar+")";
        }
        return arg0.toString();
    }
}