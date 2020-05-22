import java.util.Scanner;

public class Yehey {
    public static void main(String[] args) {
        int accountNum = 1;
        double cMeter;
        double pMeter;
        double eUsage;
        double totalDueAmount = 0.0;
        double Tot = 0.0;
        Scanner input = new Scanner(System.in);

        while (true) {

            // user enter account no
            System.out.print("Enter Account number (0 to stop ) : ");
            accountNum = input.nextInt();
            if (accountNum==1) {
                // user enter current meter reading
                System.out.print("Current meter reading : ");
                cMeter = input.nextDouble();
                // user enter previous meter reading
                System.out.print("Previous meter reading : ");
                pMeter = input.nextDouble();
                eUsage = cMeter - pMeter;
                System.out.print("Electricity Usage(in kWh) : " + eUsage);
                System.out.println();

                if (eUsage >= 1 && eUsage <= 200) {
                    totalDueAmount = 0.218 * eUsage;
                } else if (eUsage > 200 && eUsage <= 300) {
                    totalDueAmount = 0.334 * eUsage;
                } else if (eUsage > 300 && eUsage <= 600) {
                    totalDueAmount = 0.516 * eUsage;
                } else if (eUsage > 600 && eUsage <= 900) {
                    totalDueAmount = 0.546 * eUsage;
                } else {
                    totalDueAmount = 0.571 * eUsage;
                }
                System.out.println();  // total amount for the account is displayed
                System.out.println("Amount number : " + accountNum + "," + " your charge is " + "RM" + totalDueAmount);
                Tot = totalDueAmount++;
                System.out.println();

                // loop exit and displa the total amount for all accounts
                System.out.println("Total Amount collected  = " + "RM" + Tot);
                System.out.println("________________________________");
                System.out.println("--- DONE ----");
                System.out.println("________________________________");
            } else {
                System.out.println("Thank you for using my program.");
                break;
            }
        }
    }
}