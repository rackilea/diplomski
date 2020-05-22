package com.sandbox;


import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        String input = "2x^4 - 45y^4";
        input = input.replaceAll("\\D", " ");
        String[] parts = input.split("\\W+");

        System.out.println(Arrays.toString(parts));
    }
}