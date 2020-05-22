import java.util.Scanner;

public class Lab4a {
public static void main (String [] args) {
Scanner scnr = new Scanner(System.in); //creates a Scanner that will receive user input
boolean isPrime = true; //this, in the end, is where the "primeness" of the input is stored
int num; //the variable which will store the user input
boolean isOver = false; //is true once the "primeness" of the input has been decided

do { //executes at least once
    System.out.println("Enter a positive integer or 0 to exit:"); //prompts the user for input
    num = scnr.nextInt(); //stores the input

    if (num == 0) { //if the number is zero, the loop terminates; if it's negative, the loop terminates as well
        System.exit(0);
    } else if (num < 0) {
        System.out.println("Please enter a positive integer.");
        System.exit(1);
    }

    for (int mult = 2; mult <= num/2; mult++) { //divides the user input by 2, tests for if anything remains; increments by one up to the half of the number. If a remain is encountered,
                                                // isPrime becomes false and isOver true and the for loop is terminated. If not, the for loop will end with isPrime true and isOver false
        if (num % mult == 0) {
            isPrime = false;
            isOver = true;
            break;
        }
    }
} while (!isOver); //if isOver is true, the while loop ends