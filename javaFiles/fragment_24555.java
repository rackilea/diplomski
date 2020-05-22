import java.util.*;

public class Pizza {
    public static final int numbers = 15;

    public static void main(String[] args) {
        String[] toppings = new String[numbers];
        Scanner input = new Scanner(System.in);

        int attempt;
        for (attempt = 0; attempt < numbers; attempt++) {
            System.out.print("Enter topping topping (or type quit): ");
            String topping = input.nextLine();

            if (topping.equals("quit")) {
                break;
            }

            toppings[attempt] = topping;
        }

        if (attempt == numbers - 1) {
            System.out.println("No more toppings allowed.");
        } else {
            // Remove "null" elements from "toppings" array
            String[] temp = new String[attempt];

            for (int position = 0; position < attempt; position++) {
                temp[position] = toppings[position];
            }

            toppings = temp;
        }

        Arrays.sort(toppings);

        for (int position = 0; position < toppings.length; position++) {
            String element = toppings[position];

            System.out.println((position + 1) + ". " + element);
        }
    }
}