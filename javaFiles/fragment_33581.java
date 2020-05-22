package com.example;

import com.eclipsesource.v8.V8;

public class EclipseCon_snippet5 {


    public static class Printer {
        public void print(String string) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        V8 v8 = V8.createV8Runtime();
        v8.registerJavaMethod(new Printer(), "print", "print", new Class<?>[]{String.class});
        v8.executeVoidScript( "print('Hello, World!');" );
        v8.release(true);
    }

}