import java.io.*;
import java.util.Scanner;
class myInput {
    public static void main(String[] args) {
    //Retrieve name
    System.out.println("What name would you like to search for? (Enter first name only without spaces)");
    Scanner input = new Scanner(System.in);
    while (!input.hasNext("[A-Za-z]+")) {
        System.out.println("Invalid entry. Please enter first name only.");
        input.next();
    }
    String name = input.next();
    System.out.println("You gave me as input the name:" + name);
    }
}