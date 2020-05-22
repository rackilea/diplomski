package com.test.singleton;

public class Singleton {
    private static final Singleton inst= new Singleton();

    private Singleton() {
        super();
    }

    public synchronized void writeToFile(String str) {
        // Do whatever
    }

    public Singleton getInstance() {
        return inst;
    }

}