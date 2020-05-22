package com.stackoverflow.answer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleFileHelper {

    public static void main(String[] args) throws FileNotFoundException {
        File FILE_PATH = new File("C:/Users/home/Desktop/DbWord.txt");
        System.out.println(FILE_PATH.exists());
        System.out.println(FILE_PATH.getAbsoluteFile());
        FileInputStream fIn = new FileInputStream(FILE_PATH);
        Scanner reader = new Scanner(fIn);
    }
}