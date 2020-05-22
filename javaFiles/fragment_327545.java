package com.test;

public class Test implements Testeable {

    public static void main(String[] args) {

        Testeable testeable = new Test();

        // OR

        Test test = new Test();

        if (testeable instanceof Testeable)
            System.out.println("instanceof succeeded");
        if (test instanceof Testeable)
            System.out.println("instanceof succeeded");
    }
}

interface Testeable {

}