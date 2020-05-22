package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // creating Scanner and declaring and initializing our 2D array
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of rows for your 2D array: ");
        int rows = in.nextInt();
        int[][] arr = new int[rows][2];

        // asking user for values to assign to our array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value for row " + i + " column " + j + ": ");
                arr[i][j] = in.nextInt();
            }
        }

        // create a Comparator that compares by result of reduction of 2nd and first column in each array, then if the
        // results are equal (0), we compare by first column
        Comparator<int[]> cmp = Comparator.<int[]>comparingInt(x -> x[1] - x[0]).thenComparing(Comparator.comparingInt(x -> x[0]));

        // we make a stream out of the 2D array, we sort inner elements (single dimensional arrays) by the Comparator we created and we print out results
        Arrays.stream(arr)
              .sorted(cmp)
              .forEach(x -> System.out.println(Arrays.toString(x)));

    }

}