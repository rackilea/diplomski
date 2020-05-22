import java.util.Scanner;

public class Number {

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number to square: ");
        int num = in.nextInt();
        System.out.println("Your number squared is: " + square(num));
    }
    public static int square(int num) 
    {
        return num * num;
    }
}