package com.pearson.nextgen.aggregatedsessionservice;

import java.util.Scanner;

public class NameAgeTest {

    public static void main(String[] args) {
        String[] name = new String[10];
        int[] age = new int[10];
        Scanner in = new Scanner(System.in);

        String NAME_REQUEST = "Please enter name";
        String AGE_REQUEST = "Please enter age";

        int count = 0;
        while (count < 10) {
            System.out.println(NAME_REQUEST);

            String nameInput = in.next();
            if (nameInput.equalsIgnoreCase("done")) {
                break;
            }
            name[count] = nameInput;
            System.out.println(AGE_REQUEST);
            age[count] = in.nextInt();

            count++;
        }

        int[] minAndMaxIndex = findMinAndMaxIndex(age, count);
        System.out.println("Youngest Person: " + name[minAndMaxIndex[0]]);
        System.out.println("Oldest Person: " + name[minAndMaxIndex[1]]);

    }

    private static int[] findMinAndMaxIndex(int[] inputArray, int count) {
        int min, max = 0;
        int minIndex = 0, maxIndex = 0;
        max = min = inputArray[0];

        for (int i = 0; i < count; i++) {
            if (inputArray[i] > max)
                maxIndex = i;
            else if (inputArray[i] < min)
                minIndex = i;

        }
        return new int[] { minIndex, maxIndex };
    }

}