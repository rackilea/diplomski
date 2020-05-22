/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone {

public static void main(String[] args) throws java.lang.Exception {

    Scanner scan = new Scanner(System.in);

    double value, intValue;

    System.out.println("Enter your value without a comma");

    intValue = scan.nextDouble();

    System.out.println(intValue);

    scan.close();
}