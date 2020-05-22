package com.sandbox;

public class Sandbox {

    public static void main(String[] args) {
        //you can run this from the command line
        main(); //you can call the faux main
    }

    public static void main() {
        //you can't run this from the command line
        System.out.println("called");
    }       
}