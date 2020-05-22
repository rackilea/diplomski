import java.io.IOException;
import java.util.Scanner;
import static java.util.Calendar.*;

class Main {
    public static void main(String str[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("What month were you born in? (number)");
        int month = scan.nextInt() - 1;
        System.out.println("What day (number)");
        int day = scan.nextInt();
        if (((month == APRIL) && (day <= 19) || 
                (month == MARCH) && (day >= 21))) {
            System.out.println("Your birthday is: " + month + " " + day);
            System.out.println("Aries");
            System.out.println("Horoscope: ");
        } else {
            System.out.printf("Month %d, Day %d%n", month, day);
        }
    }
}