import java.io.*;
import java.util.*;

public class Main {
    public static void addiePorterMod8Banking (String args[]) {
        while (true) {
            int depositSavings, depositChecking, withdrawalSavings, withdrawalChecking, transferSavingsToChecking;
            int b, c, d, e, f, g, lp;
            int savingsaccount = 3000;
            int checkingaccount = 650;
            Scanner kbReader = new Scanner(System.in);
            System.out.println("What do you wish to do today?\n1 for deposit to savings\n2 for deposit to checking\n3 for withdraw from savings\n4 for withdraw from checking\n5 for transfer funds from savings to checking");
            int a = kbReader.nextInt();
            if (a == 1) {
                System.out.println("1-you chose to make a deposit to savings. How much would you like to deposit?");
                int answer = kbReader.nextInt();
                lp = savingsaccount + answer;
                System.out.println("Your total in savings is $" + lp);
            }
            if (a == 2) {
                System.out.println("2-you chose to make a deposit to checking. How much would you like to deposit?");
                int answer = kbReader.nextInt();
                lp = checkingaccount + answer;
                System.out.println("Your total in checking is $" + lp);
            }
            if (a == 3) {
                System.out.println("3-you chose to withdraw from savings. How much would you like to withdraw?");
                int bunny = kbReader.nextInt();
                lp = savingsaccount - bunny;
                System.out.println("Your total in savings is $" + lp);
            }
            if (a == 4) {
                System.out.println("4-you chose to withdraw from checking. How much would you like to withdraw?");
                int bubble = kbReader.nextInt();
                lp = checkingaccount - bubble;
                System.out.println("Your total in checking is $" + lp);
            }
            if (a == 5) {
                System.out.println("5-Your current balance in savings is $3000. How much would you like to transfer?");
                int awesome = kbReader.nextInt();
                lp = savingsaccount - awesome;
                int al = checkingaccount + awesome;
                System.out.println("Your total in checking is $" + al + "." + "Your total in savings is $" + lp + ".");
            }
            System.out.println("Would you like another transaction? 1 for yes. 2 for No");
            int more = kbReader.nextInt();

            if (more == 2) {
                break;
            }
        }
    }
}