import java.util.Scanner;

public class testprog {
    public static void main (String args[]) {
        String[] pizzaList = {" 0 - End of order",
            " 1 - Cheese", " 2 - Wedge", " 3 - Bacon", " 4 - Hawaiian",
            " 5 - Vegetarian", " 6 - Pepperoni", " 7 - Ham", " 8 - Apple",
            " 9 - Grape", "10 - Italian"};

        int[] orderList = new int[5];  // Ordered pizzas
        int pizzaCount = 0;            //    and count.

        Scanner pizzaPick = new Scanner(System.in);
        while (pizzaCount < 5) {
            // Output the menu.

            System.out.println ("Choose a pizza:");
            for (int i = 0; i < pizzaList.length; i++)
                System.out.println ("   " + pizzaList[i]);

            // Get input, check, and add pizza.

            int thisPizza = pizzaPick.nextInt();
            if (thisPizza == 0) break;

            if ((thisPizza > 0) && (thisPizza < pizzaList.length))
                orderList[pizzaCount++] = thisPizza;

            if ((thisPizza < 0) || (thisPizza >= pizzaList.length))
                System.out.println ("Invalid input of " + thisPizza);
        }

        // Output all pizzas.

        for (int i = 0; i < pizzaCount; i++)
            System.out.println ("Ordered: " + pizzaList[orderList[i]]);
    }
}