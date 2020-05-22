package com.stackoverflow.q14491966;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception {
        QuickRandom qr = new QuickRandom();
        int[] frequencies = new int[10];
        for (int i = 0; i < 100000; i++) {
            frequencies[(int) (qr.random() * 10)]++;
        }
        printDistribution("QR", frequencies);

        frequencies = new int[10];
        for (int i = 0; i < 100000; i++) {
            frequencies[(int) (Math.random() * 10)]++;
        }
        printDistribution("MR", frequencies);
    }

    public static void printDistribution(String name, int[] frequencies) {
        System.out.printf("%n%s distribution |8000     |9000     |10000    |11000    |12000%n", name);
        for (int i = 0; i < 10; i++) {
            char[] bar = "                                                  ".toCharArray(); // 50 chars.
            Arrays.fill(bar, 0, Math.max(0, Math.min(50, frequencies[i] / 100 - 80)), '#');
            System.out.printf("0.%dxxx: %6d  :%s%n", i, frequencies[i], new String(bar));
        }
    }

}