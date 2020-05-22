import java.util.Random;

public class Loop6 {
    public static void main(String[] args) {

        Random number = new Random();
        int randomNumber = number.nextInt(1000);  // introduce the initial variable
        int value = randomNumber;  // introduce the variable that will be updated
        System.out.println("random number : " + " " + value);

        int rev = 0;
        int dig;

        while (value > 0) {
            dig = value % 10;
            rev = rev * 10;
            rev = rev + dig;
            value = value / 10;
        }
        System.out.println("rev is : " + "" + rev);
        if (randomNumber == rev) {  // compare the initial variable and the reverse result
            System.out.println("Palindrome");

        }

    }
}