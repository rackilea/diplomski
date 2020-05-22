import java.util.Scanner;
public class CalculateBill {
public static void main( String[] args ) {
    double sum = 0;
    double cost = 0;
    int items=0;
    double unitPrice;

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the name of the item (f to end):");
    // changed to f as I don't want to have to type Finish every time
    String description = scan.next();

    while( !description.equals("f") ) { // FIXED
    System.out.println("Please enter the quantity of " + description + ": " );
    items = scan.nextInt();
    System.out.println("Please enter the unit price of " + description + ": ");
    unitPrice = scan.nextDouble();
    cost = items*unitPrice  ; // FIXED
    System.out.printf("Cost of %d %s(s) is $%.2f%n", items, description, cost);
    sum += cost; // FIXED
    System.out.println("Please enter the name of the item (F to end):");
    description = scan.next();
    }

    System.out.printf("The total bill is $%.2f%n", sum); // FIXED
}

}