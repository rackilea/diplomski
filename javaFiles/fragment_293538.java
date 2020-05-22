public class Coffee {
public static double priceA = 1.99d;
public static double priceE = 2.99d;
public static double priceL = 3.99d;
public static double totalPrice = 0d;
public static int custChoice;
public static int counter =1;
public static void main(String[] args) {
    menu();
    while (counter <3) {
        switch (custChoice) {
            case 1:
                totalPrice = totalPrice +priceA;
                break;
            case 2:
                totalPrice = totalPrice +priceE;
                break;
            case 3:
                totalPrice = totalPrice +priceL;
                break;
            case 0:
                System.out.println("Your total is $" + totalPrice);
                return;
            default:
                System.out.println("This Option is not available, please try again!");
                counter--;
                break;
        }
        counter++;
        menu();
    }
}

public static void menu() {
    Scanner input = new Scanner(System.in);
    System.out.println("Counter: " + counter);
    System.out.println("Total Price: $" + totalPrice);

    System.out.println("-----------------------------");
    System.out.println("  (1) American    1.99       ");
    System.out.println("  (2) Espresso    2.99       ");
    System.out.println("  (3) Latte       3.99       ");
    System.out.println("-----------------------------");
    System.out.println("");
    System.out.println(" Please make a selection \n\t or enter 0 to total and quit.");
    custChoice = input.nextInt();
}