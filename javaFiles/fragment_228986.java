package com.example;

import sun.misc.BASE64Encoder;

public class BASE64EncoderTest {
    public static void main(String[] args) {
        System.out.println("Testing - " + new BASE64Encoder().encode(new byte[0]));
    }
}