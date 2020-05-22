package com.stackoverflow.q2830456;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int[] ints = new int[100000];
        for (int i = 0; i < ints.length; ints[i++] = random.nextInt());

        long st = System.currentTimeMillis();
        test1(ints);
        System.out.println(System.currentTimeMillis() - st);

        st = System.currentTimeMillis();
        test2(ints);
        System.out.println(System.currentTimeMillis() - st);
    }

    static void test1(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints.clone();
        }
    }

    static void test2(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            Arrays.copyOf(ints, ints.length);
        }
    }

}