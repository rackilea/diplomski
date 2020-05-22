package pseudoPackage;
import java.util.Scanner;

public class PseudoCode {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int ship1 = 0;
        int ship2 = 6;
        int ship3 = 2;
        String shiphalf = null;

        System.out.print("How much will shipping cost you?");
        System.out.print("\nEnter your textbook cost in dollars without the $: ");
        double cost = input.nextDouble();

        if ( cost >= 100 ) {
            System.out.println("Your shipping costs are $0");
        } else if ( cost < 100 && cost > 50 ) {
            System.out.println("Your shipping cost is $6");
        } else if ( cost < 50 ) {
            System.out.println("Your shipping cost is $2");
        }

        System.out.println("Enter a Coupon Code: ");
        String ship = input.next(); 

        if ( ship.equals("shiphalf") && cost >= 100 ) {
            System.out.println("Your shipping costs are $0");
        } else if ( ship.equals("shiphalf") && cost < 100 && cost >50 ) {
            System.out.println("Your shipping costs are $3 ");
        } else if ( ship.equals("shiphalf") && cost < 50 ) {
            System.out.println("Your shipping costs are $1");
        }
    }
}