import java.io.*;
import java.util.Scanner;

public class Murray_A04Q2 {

    public static void main(String[] args) throws IOException {

        String fileName = "userStrings.txt";
        Scanner scan = new Scanner(System.in);

        try {
            FileWriter fileWriter = new FileWriter("userStrings.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter outFile = new PrintWriter(bufferedWriter);
            String input;
            System.out.print("Enter something (DONE to quit): ");
            if (!(input = scan.nextLine()).equalsIgnoreCase("DONE")) { // Added "!" (not)
                // Some one time use code goes here.
                System.out.println("Enter something else or DONE to quit: ");
                while (true) {
                    if ((input = scan.nextLine()).equalsIgnoreCase("DONE")) {
                        break;
                    }
                    // Some code goes here
                    if ((input = scan.nextLine()).equalsIgnoreCase("DONE")) {
                        break;
                    }
                    // Some DIFFERENT code goes here.
                    System.out.println(input);
                    if ((input = scan.nextLine()).equalsIgnoreCase("DONE")) {
                        break;
                    }
                    // Some code that didn't belong above can go here.
                }
            }
            bufferedWriter.write(input);
            bufferedWriter.close();
        }
        catch (IOException ex) {
            System.out.println("Error writing to file " + "userStrings.txt"
                    + "");
        }
    }
}