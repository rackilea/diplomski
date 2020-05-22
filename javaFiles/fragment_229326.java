package hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    String player = "";
    int turn = 12;
    List<String> wordBox = new ArrayList<String>();
    boolean hangman = false;
    Scanner scan;
    Random random = new Random();

    String letters;     // For displaying letters
    String mask;        // For character Mask

    public Game(String[] words, Scanner scanner){
        scan = scanner;

        int selectA = random.nextInt(words.length);

        letters = words[selectA];               //Load word into String for display. This just makes the code more readable.        
        mask = letters.replaceAll("\\S", "*");  // Mask the words

        System.out.println("Random String selected: " + mask);
        System.out.println("This word contains " + letters.length() + " letters");

        while (hangman == false) {
            System.out.println("Turns remaining: " + turn);
            System.out.println("Please choose a letter A-Z :");
            String ChosenLetter = scan.next();

            if (wordBox.contains(ChosenLetter)) {
                System.out.println("Letter already chosen please choose another letter");
            } else {
                wordBox.add(ChosenLetter);
            }

            if (letters.contains(ChosenLetter)) {
                char[] cLetters = letters.toCharArray();    //Load letters and mask to char array for editing
                char[] cMask = mask.toCharArray();

                for(int i=0; i < cMask.length; i++){
                    if(cLetters[i] == ChosenLetter.charAt(0)){
                        cMask[i] = cLetters[i];
                    }
                }

                mask = new String(cMask);   //Load new mask into String

                System.out.println("Wordbox letters are: " + wordBox);
                System.out.println("Yes!" + mask);                      // Prints mask after Yes!

                turn--;
            } else {
                System.out.println("Wordbox letters are: " + wordBox);
                System.out.println("No!" + mask);                               //Prints mask after No!
                turn--;
            }

            if (turn == 0) {
                hangman = true;
            }

            while (hangman == true) {
                System.out.println("You lose!");
                System.exit(0);
            }
        }
    }
}