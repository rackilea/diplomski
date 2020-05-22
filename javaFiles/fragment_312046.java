import java.util.Scanner;

public class CustomerAccountHandler {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the account number: ");
        String accountId = in.nextLine();
        System.out.print("Please enter the initial balance: ");
        int startingBal = Integer.parseInt(in.nextLine());

        // Create the account here
        CustomerAccount account = new CustomerAccount(accountId, startingBal);

        int updatedBal, adjustment; // create here, we will use it a lot
        String type;

        while (true) {
            System.out.println("Please enter the transaction type /(D to deposit, W to withdraw, Q to quit: ");
            type = in.nextLine();

            if(type.equals("Q")) {
                System.out.println("Quitting transactions...");
                break;
            } else if(type.equals("W") || type.equals("D")) {
                System.out.println("Please enter the amount to be deposited or withdrawn: ");
                adjustment = Integer.parseInt(in.nextLine());

                if (type.equals("D")) {
                    updatedBal = account.deposit(adjustment);
                    System.out.println("Updated Balanced : " + updatedBal);
                } else if(type.equals("W")) {
                    updatedBal = account.withdraw(adjustment);
                    System.out.println("Updated Balanced : " + updatedBal);
                }
            } else {
                System.out.println("Please enter a valid Command: D,W,Q");
            }
        }

        System.out.println("\nAccount Number: " + account.getAccountId() + "    UpdatedBalance: $" + account.getAmount());
    }
}