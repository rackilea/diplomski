import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a list of numbers: ");

        while (keyboard.hasNextDouble()) {
            double input = keyboard.nextDouble();
            numbers.add(input);
            if (input == -99)
                break;
        }
        Double max = Collections.max(numbers);
        System.out.println("The Maximum is: " + max); // you have missed to add max here
    }
}