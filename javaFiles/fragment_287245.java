import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]){

        try {
            int total = 0;

            File file = new File("expenditure.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                total += fileScanner.nextInt();
            }
            fileScanner.close();

            System.out.println("The total expenditure is " + total);
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
        }
    }
}