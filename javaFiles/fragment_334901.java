package com.someco;

import org.aopalliance.intercept.MethodInvocation;

public class GoodbyeMethodInterceptor implements org.aopalliance.intercept.MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Goodbye");

        return null;
    }

}