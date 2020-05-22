package returnin;

import java.util.*;

public class trycatch {
    public static void main(String[] args) {
        // Don't recreate Scanner inside input method.
        Scanner sc = new Scanner(System.in);

        // Read once
        String chck = input(sc);

        // Loop until check is okay
        while (!check(chck)) {
            // read next
            chck = input(sc);
        }
        System.out.println("If you see this message it means that you passed the test");
    }

    static String input(Scanner sc) {
        System.out.println("Enter a value");
        return sc.nextLine();
    }

    static boolean check(String a) {
        try {
            // Try parsing as an Integer
            Integer.parseInt(a);
            System.out.println("You entered an Integer");
            return true;
        } catch (NumberFormatException nfe) {
            // Not an Integer
        }
        try {
            // Try parsing as a long
            Long.parseLong(a);
            System.out.println("You entered a Long");
            return true;
        } catch (NumberFormatException nfe) {
            // Not an Integer
        }
        try {
            // Try parsing as a double
            Double.parseDouble(a);
            System.out.println("You entered a Double");
            return true;
        } catch (NumberFormatException nfe) {
            // Not a Double
        }
        System.out.println("You entered a String.");
        return false;
    }
}