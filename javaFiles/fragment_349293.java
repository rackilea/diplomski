import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int repeat = 1;
        while (repeat == 1) {
            System.out.println("Input your equation");
            String equation = input.nextLine(); // Takes the user input and sets it equal to a variable (equation)
            if (equation.equals("quit")) { // If the user inputs 'quit'
                System.out.println("You've quit out of the calculator.");
                repeat = 2; // repeat is set to 2 so the program can no longer run and it terminates.
            } else {
                System.out.println("Your answer is: " + produceAnswer(equation));//EDIT
            }
        }
    }

    public static String produceAnswer(String input) {

        Scanner fraction = new Scanner(input);
        String num1 = fraction.next().trim();
        String op = fraction.next().trim();
        String num2 = fraction.next().trim();
        // Creates an empty string for each necessary variable for values to be added to them later on.
        String plus = "+";
        String multiply = "*";
        String division = "/";
        String subtract = "-";
        String whole = "";
        String numer = "";
        String denom = "";
        String whole2 = "";
        String numer2 = "";
        String denom2 = "";
        // Creates variables ansnum and ansden to be manipulated later on in the calculations.
        int ansnum = 0;
        int ansden = 0;
        // Creates place and place2 to act as counters to go through each token of the original equation input.
        int place = 0;
        int place2 = 0;
        String input1 = ""; // Sets an empty string variable for the return.
        if (num1.contains("_")) { // If the first fraction contains an _
            while (num1.charAt(place) != '_') { // while the place (index) isn't equal to that _
                whole += num1.charAt(place); // Set everything before it, equal to whole.
                place++; // Each time increase the place (index) by 1.
            }
            place++; // Increases the place by 1 to pass the _ and move onto the next part of the fraction
        }//EDIT
        if (num1.contains("/")) { // If the first fraction contains a forward slash
            while (num1.charAt(place) != '/') { // While the place does not equal its index
                numer += num1.charAt(place); // Add every thing before it to a variable called numer
                place++; // Each time increases the place (index) by 1.
            }
            place++; // Increases the place by 1 to pass the / and move onto the denominator.
        }//EDIT
        while (place != num1.length()) { // While the place (index) is less than the length of fraction 1
            denom += num1.charAt(place); // Add every thing before it equal to the denom variable.
            place++; // Each time increases the place (index) by 1.
        }
        place++;
        // Same process as above is repeated for fraction 2.
        if (num2.contains("_")) {
            while (num2.charAt(place2) != '_') {
                whole2 += num2.charAt(place2);
                place2++;
            }
            place2++;
        }//EDIT
        if (num2.contains("/")) {
            while (num2.charAt(place2) != '/') {
                numer2 += num2.charAt(place2);
                place2++;
            }
            place2++;
        }//EDIT
        while (place2 != num2.length()) {
            denom2 += num2.charAt(place2);
            place2++;
        }

        // All those string variables with the values are converted into integers to be used in calculations.
        int wholenum = (whole.equals("")) ? 0 : Integer.parseInt(whole);//EDIT
        int wholenum2 = (whole2.equals("")) ? 0 : Integer.parseInt(whole2);//EDIT
        int numerator1 = Integer.parseInt(numer);
        int denominator1 = Integer.parseInt(denom);
        int numerator2 = Integer.parseInt(numer2);
        int denominator2 = Integer.parseInt(denom2);

        // Calculates the whole number into the fraction to get rid of any mixed numbers.
        int wholenumerator1 = ((wholenum * denominator1) + numerator1);
        int wholenumerator2 = ((wholenum2 * denominator2) + numerator2);

        if (op.equals(plus)) { // If the operator is addition
            ansnum = ((wholenumerator1 * denominator2) + (denominator1 * wholenumerator2)); // Cross multiply to get the numerator.
            ansden = (denominator1 * denominator2); // Multiply both denominators to get a common denominator.
        } else if (op.equals(multiply)) { // If the operator is multiplication
            ansnum = (wholenumerator1 * wholenumerator2); // multiples both numerators.
            ansden = (denominator1 * denominator2); // multiplies both denominators
        } else if (op.equals(division)) { // If the operator is division
            ansnum = (wholenumerator1 * denominator2); // multiplies numerator1 by the reciprocal of fraction 2 (denominator2)
            ansden = (denominator1 * wholenumerator2); // multiplies denominator 1 by numerator2.
        } else if (op.equals(subtract)) {
            ansnum = ((wholenumerator1 * denominator2) - (wholenumerator2 * denominator1)); // multiplies numerator1 by denominator 2 and numerator 2 by denominator 1
            ansden = (denominator1 * denominator2); // multiples both denominators to find a common denominator
        }
        input1 = (ansnum + "/" + ansden);//EDIT
        return input1;
    }
}