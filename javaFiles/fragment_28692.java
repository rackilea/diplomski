package one.two;

import one.Bar;

public class Foo {

    public void doSomething() {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];
        String className = stackTraceElement.getClassName();

        if (Bar.class.getName().equals(className)) {
            System.out.println("jay!");
        } else {
            throw new RuntimeException("not allowed");
        }

    }
}