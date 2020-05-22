import java.util.*;

public class Pizza {
    public static final int numbers = 15;

    public static void main(String[] args) {
        List<String> toppings = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int attempt;
        for (attempt = 0; attempt < numbers; attempt++) {
            System.out.print("Enter topping topping (or type quit): ");
            String topping = input.nextLine();

            if (topping.equals("quit")) {
                break;
            }

            toppings.add(topping);
        }

        if (attempt == numbers) {
            System.out.println("No more toppings allowed.");
        }

        Collections.sort(toppings);

        for (int position = 0; position < toppings.size(); position++) {
            System.out.println((position + 1) + ". " + element);
        }
    }
}