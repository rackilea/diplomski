package com.test;

public class DeadLock {

    private void method1() {

        synchronized (Integer.class) {
            boolean runInThread = false;

            if( runInThread ) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        method2();
                    }
                };
                t.start();
                try {
                    t.join(); // this never returns
                } catch( InterruptedException e ) {
                    e.printStackTrace();
                }
            } else {
                method2();
            }
        }
    }

    private void method2() {
        System.out.println("trying to lock");
        synchronized (Integer.class) {
            System.out.println("hi there");
        }
    }

    public static void main(String[] args) {
        new DeadLock().method1();
    }
}