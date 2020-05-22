package com.test;

public class MyLock {

    private volatile boolean condition;

    public MyLock(boolean condition) {
        this.condition = condition;
    }

    public boolean condition() {
        return condition;
    }

    public void flipCondition() {
        condition = !condition;
    }
}