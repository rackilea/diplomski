package com.test;

import java.util.Arrays;

public class TestCombo {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3};

        int resultCount = (int)Math.pow(2, arr.length);
        int[] result = new int[resultCount - 1];

        for(int i = 1; i < result.length + 1; i++) {
            int j = i;

            int sum = 0;

            for(int arrI = 0; j != 0; arrI++) {
                if( (j & 1) == 1) { //Is arrI bit turned on?
                    sum += arr[arrI];
                }

                j = j >> 1;
            }

            result[i-1] = sum;
        }

        Arrays.stream(result).forEach(System.out::println);;
    }
}