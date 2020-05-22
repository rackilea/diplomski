import java.util.Scanner;

public class PizzaTwo {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the details of your order");
        String flavors = scan.nextLine();

        int price = 0;
        StringBuilder order = new StringBuilder();

        for (int i = 0; i < flavors.length(); i++) {
            switch (flavors.charAt(i)) {
            case 'a':
                order.append("apple ");
                price += 10;
                break;
            case 's':
                order.append("spinach ");
                price += 5;
                break;
            case 'd':
                order.append("dog ");
                price += 15;
                break;
            case 'f':
                order.append("frog ");
                price += 20;
                break;
            case 'g':
                order.append("goat ");
                price += 25;
                break;
            default:
                order.append("No flavor added ");
                break;
            }
        }

        System.out.println(order.append(price));
    }
}