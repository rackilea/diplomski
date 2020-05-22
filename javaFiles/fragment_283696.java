package com.company;
import java.util.Random;
public class Main {
    public static int sum(int[] array) {
        int x = array[0];
        int y = array[9];
        int z = x + y;
        return z;
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50);
        }
        System.out.println(sum(array));
    }
}