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
            while ((input = scan.nextLine()).equalsIgnoreCase("DONE")) {
                System.out.println(input);
                // Some code can go here.
                System.out.println("Enter something else or DONE to quit: ");
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