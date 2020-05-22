package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Replace array.txt with the name of your txt file and your path
        Scanner fileScanner = new Scanner(new File("array.txt"));
        // Counter variable so we'll know the size of the array we'll need
        int counter = 0;
        // Iterate through the file counting the number of integers and incrementing the counter variable
        while(fileScanner.hasNextInt()){
            counter++;
            fileScanner.nextInt();
        }
        // Reset the scanner to the beginning of the txt file
        fileScanner = new Scanner(new File("array.txt"));

        // Scan each integer into the array
        int [] array = new int[counter];
        for (int i = 0; i < array.length; ++i) array[i] = fileScanner.nextInt();
    }
}