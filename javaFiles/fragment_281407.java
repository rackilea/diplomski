package com.company;

public class Test {
    private static boolean isInitialized = false;

    static Thread t = new Thread(new Runnable() {
        public void run() {
            isInitialized = true;
        }
    });
    static {
        t.start();
    }

    public static void main(String[] args) {
        try {
            t.join();
        } catch (InterruptedException ignored) { }

        System.out.println(isInitialized);
    }
}