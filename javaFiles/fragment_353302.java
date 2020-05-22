import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = "Input your number: ";
            System.out.print(userInput);
            String input = scanner.nextLine();
            // look for integer (+ve, -ve or 0)
            if (input.matches("^-?[0-9]+$")) {
                int z = Integer.parseInt(input);
                System.out.println(display(z));
            // look for double (+ve, -ve or 0)
            } else if (input.matches("^-?([0-9]+\\.[0-9]+|[0-9]+)$")) {
                double z = Double.parseDouble(input);
                System.out.println(display(z));
            // look for end of program by user
            } else if (input.equals("")) {
                System.out.println("Good Bye!!");
                break;
            // look for bad input
            } else {
                System.out.println("Hey! Only numbers!");
            }
        }
        scanner.close();
    }

    // handle integer and display message appropriately
    private static String display(int d) {
        return (d>0) ? (d + " is positive") : (d<0) ? (d + " is negative") : (d + " is equal to 0");
    }

    // handle double and display message appropriately    
    private static String display(double d) {
        return (d>0) ? (d + " is positive") : (d<0) ? (d + " is negative") : (d + " is equal to 0");
    }
}