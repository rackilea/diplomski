import java.io.*;
import java.util.*;

public class BankAccount {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File dir = new File("BankAccounts.txt");
        System.out.println("Please enter your bank account number.");
        String bankNumber = input.nextLine();
        input.close();
        System.out.println("Your Balance is: "
                + balanceFromAccount(bankNumber, dir));
    }

    public static String balanceFromAccount(String accountNumber, File file) {
        String tempNumber = "";
        int i;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                for (i = 0; line.charAt(i) != ' '; i++) {
                    tempNumber = tempNumber.concat(line.substring(i, i + 1));
                }
                if (tempNumber.equals(accountNumber)) {
                    return line.substring(i + 1);
                }
                tempNumber = "";
            }
            br.close();
        } catch (Exception e) {

        }
        return "Not Found!";

    }

}