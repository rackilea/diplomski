import java.io.*;
import java.util.*;

public class Experiments { // class header

    private static String[] words = readArray("/Users/UserName/Desktop/words.txt"); //change to your location of the file

    public static void main(String[] args) { // Method header
        int option = 0;
        Scanner input = new Scanner(System.in);
        int counter = 0;
        String scrambledWord;
        int index1;
        int index2;     

        Random rand = new Random();
        int randWord = rand.nextInt(words.length);

        for (int j = 0; j < words[randWord].length(); j += 1) {
            System.out.print(j);
        }

        System.out.print("\n");     
        scrambledWord = scrambler(words[randWord]);
        System.out.println(scrambledWord);     

        System.out.println("\n");
        System.out.println("Enter 1 to swap a pair of letters.");
        System.out.println("Enter 2 to show the solution and quit.");
        System.out.println("Enter 3 to quit."); 
        option = input.nextInt();

        if (option == 1) {
            while (!scrambledWord.equals(words[randWord])) {
                index1 = 0;
                index2 = 0;
                boolean validOption = false;
                System.out.println("Enter the two index locations to swap separated by a space.");
                while (!validOption) {
                    if (input.hasNextInt()) {
                        index1 = input.nextInt();
                        index2 = input.nextInt();  
                        validOption = true;
                    }
                    else {
                        System.out.println("Please enter only numbers.");
                        validOption = false;
                        break;
                    }
                }
                String letter1 = scrambledWord.substring(index1, index1+1);
                String letter2 = scrambledWord.substring(index2, index2+1);
                System.out.println("replacing " + letter1 + " with " + letter2 + "...");
                if (index1 < index2) {
                    scrambledWord = scrambledWord.replaceFirst(letter2, letter1);                 
                    scrambledWord = scrambledWord.replaceFirst(letter1, letter2); 
                } else {
                    scrambledWord = scrambledWord.replaceFirst(letter1, letter2);                 
                    scrambledWord = scrambledWord.replaceFirst(letter2, letter1); 
                }
                System.out.println();
                for (int j = 0; j < words[randWord].length(); j += 1) {
                    System.out.print(j);
                }
                System.out.println("\n"+scrambledWord);
                System.out.println();
                counter++;
                if (scrambledWord.equals(words[randWord])){
                    System.out.println("You did it! The word was " + words[randWord]);
                    System.out.println("You got it with " + counter + " replacements!");
                    words[randWord] = null;
                    if (words.length == 0){
                        System.out.println("I'm all out of words. You win!");
                        System.exit(0);
                    } else {
                        main(args);
                    }
                }
            } 

        } else if (option == 2) {
            System.out.println(words[randWord]);
            System.exit(0);
        } else {
            System.exit(0);
        }
        input.close();
   }   

    //scrambles the word given to it
    private static String scrambler(String word) { 
        String scrambled = "";
        Random rand = new Random();
        int length;
        int index;
        String letter;
        String firststring;
        String secondstring;

        while (word.length()>0) {
            length = word.length();
            index = rand.nextInt(length);
            letter = word.substring(index, index+1);
            firststring = word.substring(0, index);
            secondstring = word.substring(index+1);
            word = firststring + secondstring;
            scrambled += letter;
        }
        return scrambled;
    }

    public static String[] readArray(String file) {
        int ctr = 0;
        try {
            Scanner s1 = new Scanner(new File(file));
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.nextLine();
            }
            String[] words = new String[ctr];

            // Step 2:
            Scanner s2 = new Scanner(new File(file));
            for (int i = 0; i < ctr; i = i + 1) {
                words[i] = s2.next();

            }
            return words;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        }
}