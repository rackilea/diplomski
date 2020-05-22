// File: HeartRatesTest.java
// Testing heart rate class
import java.util.Scanner;

public class HeartRatesTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String firstName;
        String lastName;
        int month;
        int day;
        int year;

        // collecting user's information
        System.out.print("Enter your first name: ");
        firstName = input.nextLine(); // no need of setFirstName()

        System.out.print("Enter your last name: ");
        lastName = input.nextLine(); // no need of setLastName()

        System.out.print("Enter your date of birth(month day year): ");
        month = input.nextInt(); // no need of setMonth()
        day = input.nextInt();   // no need of setDay()
        year = input.nextInt();  // no need of setYear()

        /* Object of HeartRates is defined after reading all values */
        HeartRates profile = new HeartRates(firstName, lastName, month, day, year); // calling constructor with arguments

        // displaying user's information
        System.out.printf("\nFirst Name: %s\n", profile.getFirstName());
        System.out.printf("Last Name: %s\n", profile.getLastName());
        System.out.printf("Date of birth: %d\\%d\\%d\n", profile.getMonth(), profile.getDay(), profile.getYear());
        System.out.printf("Age: %d\n", profile.ageInYears());
        System.out.printf("Maximum heart rate: %d BPM\n", profile.maxHeartRate());
        System.out.printf("Target heart rate: " + profile.targetHeartRate());

    } // end method main
} // end class HeartRateTest