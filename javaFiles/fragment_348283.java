package com.sandbox;

public class Sandbox {
    public static void main(String[] args) throws Exception2 {
        throw new Exception2();
    }

    public static class Exception1 extends Exception {

    }

    public static class Exception2 extends Exception {

    }

    public static class Exception3 extends Exception {

    }


}