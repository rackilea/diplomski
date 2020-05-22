import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number (0 to quit): ");

        double largest = 0, nextDouble;
        int count = 0;

        while ((nextDouble = scan.nextDouble()) != 0) {
            if (nextDouble > largest || largest == 0) {
                largest = nextDouble;
                count = 1;
            }
            else if (nextDouble == largest) count++;
        }

        scan.close();

        if (count == 0) {
            System.out.println("No number entered!");
            return;
        }

        System.out.println("Largest #: " + largest);
        System.out.println("Occurance: " + count);

    }
}