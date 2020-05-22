import java.io.IOException;
import java.util.Scanner;

    public class SOScrap {
    public static void main (String [] args) throws IOException {
    int a;
    int b;
    String y;
    String x;
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter number A:");
    a = input.nextInt();

    System.out.println("\nPlease enter number B:");
    b = input.nextInt();

    System.out.println("\nLastly, enter A if you wish it to be the dividor and/or subtractor, or if you wish it to be B, please enter B :");
    y=input.next();

    System.out.println("\nWhat would you like to do? Multiply (*), Divide (/), Subtract (-) or Add (+)? Please enter the symbol of which process you would like to have completed:");
    x=input.next();


    if (y.equals("B") || y.equals("b")) {

    if (    x.equals("*")) {
    System.out.println("\nThe product of these numbers is:" + (a*b));}
    else
    if (x.equals("/")) {
    System.out.println("\nThe quotient of these numbers is:" + (a/b));}
    else
    if (x.equals("+")) {
    System.out.println("\nThe sum of these numbers is:" + (a+b));}
    else
    if (x.equals("-")) {
    System.out.println("\nThe difference of these numbers is:" + (a-b));}}
    else{
    if (y.equals("A") || y.equals("a")){

    if (x.equals("*")) {
    System.out.println("\nThe product of these numbers is:" + (b*a));}
    else
    if (x.equals("/")) {
    System.out.println("\nThe quotient of these numbers is:" + (b/a));}
    else
    if (x.equals("+")) {
    System.out.println("\nThe sum of these numbers is:" + (b+a));}
    else
    if (x.equals("-")) {
    System.out.println("\nThe difference of these numbers is:" + ((b-a)));}}}
           }}