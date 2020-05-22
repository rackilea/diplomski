import java.util.Scanner;
public class FirstLastInt {
    public static void main (String[] args) {
        int ldig, num;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter an Integer.");
        num = in.nextInt();

        ldig = num % 10;

        // keep looping num until it is in the range of 0-9
        while (num >= 10) {
            num = num / 10;
        }
        //initialize fdig variable and set it equal to num, just to make things clearer
        int fdig = num;

        System.out.println("The first digit is " + fdig + ", and the last digit is " + ldig + ".");
    }
}