import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int counter = 0;

    public static void main(String[] args) {
        String command;
        String[] commands = { "sorted", "factorial", "gcd", "help", "quit" };
        Scanner scnr = new Scanner(System.in);
        intro();
        help();
        System.out.println("Please type in your command below.");
        boolean isValid = true;

        while (isValid) {
            System.out.print(">>> ");
            command = scnr.nextLine().toLowerCase(); // instead of getting the input per space, get all the input per
                                                        // line
            String[] userCommand = command.split(" "); // split the line by spaces

            // check if the command has at least 2 parameters except for "help" and "quit"
            if (!commands[3].equals(userCommand[0]) && !commands[4].equals(userCommand[0]) && userCommand.length < 2) {
                System.out.println("Invalid command: " + command);
                continue;
            }

            // since you know that the first word will be the command, you just have to get
            // the value of index 0
            // FACTORIAL
            // use equals do not use startsWith or contains since it will hold true for
            // inputs "FACTORIALINVALID 4"
            if (commands[1].equals(userCommand[0])) {
                // check if the command has the correct number of parameters, in this case it
                // must have exactly 2 parameters
                if (userCommand.length != 2) {
                    System.out.println("Invalid command: " + command);
                    continue;
                }
                try {
                    // get the number for the factorial and convert it into an int
                    int num = Integer.parseInt(userCommand[1]);
                    if (num >= 0) {
                        System.out.println(num + "! == " + factorial(num));
                    } else {
                        System.out.println("Error: " + num + "! undefined");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Not a number: For input string: " + command);
                }

                // GCD
                // use equals do not use startsWith or contains since it will hold true for
                // inputs "GCDINVALID 4 5"
            } else if (commands[2].equals(userCommand[0])) {
                // check if the command has the correct number of parameters, in this case it
                // must have exactly 3 parameters
                if (userCommand.length != 3) {
                    System.out.println("Invalid command: " + command);
                    continue;
                }
                try {
                    // get the number for the GCD and convert it into an int
                    int numA, numB;
                    numA = Integer.parseInt(userCommand[1]);
                    numB = Integer.parseInt(userCommand[2]);
                    System.out.println("gcd(" + numA + ", " + numB + ") == " + GCD(numA, numB));
                } catch (NumberFormatException e) {
                    System.out.println("Not a number: For input string: " + command);

                }
                // SORTED

                // use equals do not use startsWith or contains since it will hold true for
                // inputs "SORTEDINVALID 4 5 6"
            } else if (commands[0].equals(userCommand[0])) {
                // check if the command has the correct number of parameters, in this case it
                // must at least 2 parameters
                if (userCommand.length < 2) {
                    System.out.println("Invalid command: " + command);
                    continue;
                }
                try {
                    List<Integer> nums = new ArrayList<Integer>();

                    // get the list
                    for (int i = 1; i < userCommand.length; i++) {
                        nums.add(Integer.parseInt(userCommand[i]));
                    }
                    sorted(nums);
                } catch (NumberFormatException e) {
                    System.out.println("Not a number: For input string: " + command);
                }
                // QUIT
                // use equals do not use startsWith or contains since it will hold true for
                // inputs "QUITINVALID"
            } else if (commands[4].equals(userCommand[0])) {
                isValid = false;
                quit();
                // HELP
                // use equals do not use startsWith or contains since it will hold true for
                // inputs "HELPINVALID"
            } else if (commands[3].equals(userCommand[0])) {
                help();
            }
        }
        scnr.close();
    }

    public static void intro() {
        System.out.println("This program can calculate factorials, "
                + "\nGCD, and check to see if a list of numbers are in order" + "\n-----------------------------------"
                + "\nMade by Amr Ghoneim (A00425709)" + "\n-----------------------------------");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;

        } else {
            int num = 1;
            for (int i = 1; i <= n; i++) {
                num *= i;
            }
            return num;
        }
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    public static void help() {
        System.out.println("Valid commands are:" + "\n - factorial #" + "\n     The product of all numbers from 1 to #."
                + "\n     (The argument must not be negative.)" + "\n - gcd # #"
                + "\n     The greatest common divisor of the two numbers."
                + "\n     The biggest number that divides evenly into both of them." + "\n - sorted #..."
                + "\n     Whether the numbers are in order from smallest to largest."
                + "\n     If not, then where the first out-of-order number is." + "\n - help"
                + "\n     This help message." + "\n - quit" + "\n     End the program.");
    }

    public static boolean sorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                System.out.println("Out of order: " + nums.get(i) + " after " + nums.get(i - 1));
                return false;
            }
        }
        System.out.println("That list is sorted.");
        return true;
    }

    public static void quit() {
        System.out.println("Good-bye.");
        System.exit(0);
    }

}