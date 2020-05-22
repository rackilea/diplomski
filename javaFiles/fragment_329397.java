import java.util.Scanner;

public class Calculators {

    public static void menudisplayer() {

        Scanner myObj = new Scanner(System.in); // Create a Scanner object

        while(true) { // loops indefinitely

            System.out.println("0 - Exit" + "\n" + "1 - Add" + "\n" + "2  - Subtract" + "\n" + "3 - Divide " + "\n" + "4 - Multiply" + "\n" + "5 - Average" + "\n" + "6 - Maximum"); //printing men
            System.out.println("Please type in the operation that you would like to use");
            String operations = myObj.nextLine(); // Read user input

            // Break out of the loop if user chose 0
            if (operations.equalsIgnoreCase("0"))
                break;

            System.out.println("You Entered: " + operations); // Output user input

            double value1, value2, answer=0;
            Scanner scanvalues = new Scanner(System.in);

            System.out.print("Enter any two Double Values" + "\n");
            value1 = scanvalues.nextDouble();
            value2 = scanvalues.nextDouble();

            if (operations.equalsIgnoreCase("1")) {
                answer = value1 + value2;
            } else if (operations.equalsIgnoreCase("2")) {
                answer = value1 - value2;
            } else if (operations.equalsIgnoreCase("3")) {
                answer = value1 / value2;
            } else if (operations.equalsIgnoreCase("4")) {
                answer = value1 * value2;
            } else if (operations.equalsIgnoreCase("5")) {
                answer = (value1 + value2) / 2;
            } else if (operations.equalsIgnoreCase("6")) {
                answer = Math.max(value1, value2);
            }

            System.out.println("value1=" + value1 + "\nvalue2=" + value2 + "\nAnswer=" + answer + "\n");

        }
    }

    public static void main(String[] args) {
        menudisplayer();
    }
}