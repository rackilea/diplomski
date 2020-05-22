import java.util.Calendar;
import java.util.Scanner;

public class SwitchCase {
    public static void main(String args[]) {
        boolean exit = false;
        do {
            System.out.println("Select your choice");
            System.out.println("1. To Calculate your Age");
            System.out.println("2. Calculator");
            System.out.println("3. To Exit");
            Scanner sc1 = new Scanner(System.in);
            int choice = sc1.nextInt();
            switch (choice) {
            case 1:
                Calendar c1 = Calendar.getInstance();
                int currDate = c1.get(Calendar.DATE);
                // System.out.println(currDate);
                int currMonth = c1.get(Calendar.MONTH) + 1;
                // System.out.println(currMonth);
                int currYear = c1.get(Calendar.YEAR);
                // System.out.println(currYear);
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Enter your Birth date(DD): ");
                int birthDate = sc2.nextInt();
                System.out.println("Enter your Birth month(MM): ");
                int birthMonth = sc2.nextInt();
                System.out.println("Enter your Birth year(YYYY): ");
                int birthYear = sc2.nextInt();
                int calculateDate = 0;
                calculateDate = currDate - birthDate;
                int calculateMonth = currMonth - birthMonth;
                int calculateYear = currYear - birthYear;
                System.out.println("You are : " + calculateDate + "days " + " "
                        + calculateMonth + "months " + calculateYear
                        + "years OLD");
                System.out.println("thank you..");
                System.out.println("\n");
                break;
            case 2:
                System.out.println("This is case 2");
                break;
            case 3:
                exit = true;
                break;
            }
        } while (!exit);
    }
}