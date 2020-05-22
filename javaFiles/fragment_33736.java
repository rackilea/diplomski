import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
// It is a bad practice to start a Java class name with a lower case character
public class IdentifiableImpl {


public static void main(String[] args) throws FileNotFoundException {
    Double currentbalance = 500.00;
    System.out.println("To deposit enter 1");
    System.out.println("To Withdrwawl enter 2");
    Scanner depositOrWithdrawl = new Scanner(System.in);
    int choose = depositOrWithdrawl.nextInt();
    if (choose == 1) {

        double currentBalance = 500.00;
        System.out.println("your current balance is: $" + currentBalance);
        System.out.println("Please enter the file name to deposit: ");
        // Scanner deposit = new Scanner(System.in);
        String depositAmount = depositOrWithdrawl.nextLine();
        File depositFile = new File(depositAmount);
        //  Create a stream to read from a file
        BufferedReader br = new BufferedReader(new FileReader(depositFile));
        // String st;
        // int nextLine = 1;
        String input;
        // Read a file line by line
        try {
            while ((input = br.readLine()) != null) {
                try {
                    // Convert read line into double
                    double numbers = Double.valueOf(input);
                    System.out.println("You are about to add: $" + numbers + " To your Balance");
                    currentBalance = currentBalance + numbers;
                    System.out.println("Your current balance is: $" + currentBalance);
                    // nextLine++;
                } 
// Handle bad input gracefully
catch (NumberFormatException e) {
                    System.out.println("Seems like there is an invalid amount in input file." + input
                            + " Will not proceed further");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//Close the stream in finally block
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

}