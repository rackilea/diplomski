package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int firstNum = 1;
        int secondNum = 1;

        while(firstNum !=0 && secondNum != 0)
        {
            System.out.println("first number: ");
            firstNum = sc.nextInt();

            System.out.println("second number: ");
            secondNum = sc.nextInt();

            System.out.println("The  sum of your numbers: " + (firstNum + secondNum));
        }
    }
}