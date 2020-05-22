package com.examples;

public class Example {  
    public static void main(String[] args) {
        Runnable runner = new Runnable() {          
            @Override
            public void run() {
                System.out.println(this.getClass());
            }
        };
        runner.run();
    }
}