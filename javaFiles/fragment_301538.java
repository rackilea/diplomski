import java.util.Scanner;
import java.io.*;

public class P6B {

    public static void main(String args[]) throws IOException {
        Scanner reader = new Scanner(new File("C:\\Users\\Madhawa.se\\Desktop\\workingfox\\m2.txt"));
        Scanner input = new Scanner (System.in);
        int CountWord = 0;
        String word = null;

        System.out.println("\nThis program will read a text file with 50 random   words"
                + "\nWhat word would you like to look up that may be repeated: ");

         String text = input.next();
        while (reader.hasNext()) {
            word=reader.nextLine();
            if (text.equals(word)) {
                CountWord++;
            }
        }//to get words and return the value of how many times it was found
        if (CountWord != 0) {
            System.out.println("\nI have found your word " + CountWord + " times.");
        } else if (CountWord == 0) {
            System.out.println("\nNo word found in the text file.");
        }//end of if if error
    }
}