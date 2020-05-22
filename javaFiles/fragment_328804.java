import java.util.Scanner;

public class DigitExtractor {

    public static void main(String[] args) throws java.io.IOException {

        try (Scanner input = new Scanner(System.in)){

            System.out.print("Input an integer");
            int integer = input.nextInt();
            Methods num = new Methods(integer);
            char keyboard;

            do {
                System.out.println("show (W)hole number.");
                System.out.println("show (O)nes place number.");
                System.out.println("show (T)ens place number.");
                System.out.println("show (H)undreds place number.");
                System.out.println("(Q)uit");
                System.out.println("Enter your choice: ");
                keyboard = input.next().charAt(0);

                if (keyboard == 'W' || keyboard == 'w') {
                    System.out.println("The whole number is: " + integer);
                } else if (keyboard == 'O' || keyboard == 'o') {
                    System.out.println("The ones place digit is: " + num.ones(integer));
                } else if (keyboard == 'T' || keyboard == 't') {
                    System.out.println("The tens place digit is: " + num.tens(integer));
                } else if (keyboard == 'H' || keyboard == 'H') {
                    System.out.println("The hundreds place digit is: " + num.hundreds(integer));
                }
            } while ((keyboard != 'q') && (keyboard != 'Q'));
        }
    }
}

class Methods { 

    public Methods (int value) {}

    public int hundreds (int num) {
        return (num /100)%10;
    }

    public int tens (int num) {
        return (num / 10)%10;
    }

    public int ones (int num) {
        return num % 10;
    }
}