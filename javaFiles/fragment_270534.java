import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class HangMan {

    private static List<Character> guessedCharList = new ArrayList<Character>();
    private static List<Character> validCharList = new ArrayList<Character>();
    private static String rndWord = null;

    private static int numberOfWrongGuess = 0;

    public static void main(String[] args) {
        String[] words = { "javascript", "declaration", "object", "program",
                "failing" };
        // generate random word from list
        Random rnd = new Random();

        rndWord = words[rnd.nextInt(words.length)];
        System.out.println(rndWord);
        // gets length of generated word
        char[] displayArray = new char[rndWord.length()];
        // displays "_" for number of chars in word

        for (int i = 0; i < rndWord.length(); i++) {
            displayArray[i] = '_';
        }
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                +'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', +'x', 'y', 'z' };

        String hangman = null;
        boolean finished = false;
        do {

            hangman = "Let's Play Hangman!!" + "\n" + "-------------" + "\n"
                    + "|" + "\n" + "|" + "\n" + "|" + "\n" + "|" + "\n" + "|"
                    + "\n" + "|" + "\n" + "|" + "\n" + "|" + "\n" + "\n"
                    + Arrays.toString(displayArray) + "\n" + "       ";

            JOptionPane.showMessageDialog(null,
                    hangman + " " + Arrays.toString(alphabet) + " ");
            guess();

            for (int i = 0; i < rndWord.length(); i++) {

                if (validCharList.contains(rndWord.charAt(i)))
                    displayArray[i] = rndWord.charAt(i);
                else
                    displayArray[i] = '_';
            }

            for (char c : displayArray) {
                if (c == '_') {
                    finished = false;
                    break;
                } else
                    finished = true;
            }

            if (numberOfWrongGuess >= 5) { // 5 wrong guess: "he was hanged."
                JOptionPane.showMessageDialog(null, "Man was hanged!");
                finished = true;
            }
        } while (!finished);

        hangman = "Let's Play Hangman!!" + "\n" + "-------------" + "\n" + "|"
                + "\n" + "|" + "\n" + "|" + "\n" + "|" + "\n" + "|" + "\n"
                + "|" + "\n" + "|" + "\n" + "|" + "\n" + "\n"
                + Arrays.toString(displayArray) + "\n" + "       ";
        JOptionPane.showMessageDialog(null,
                hangman + " " + Arrays.toString(alphabet) + " ");
    }

    // get letter
    public static String guess() {
        String guessStr = "";

        while (guessStr == null || guessStr.trim().isEmpty()
                || guessStr.length() > 1) {
            guessStr = JOptionPane.showInputDialog("Enter a letter to guess: ");
        }

        char c = guessStr.toLowerCase().toCharArray()[0];

        if (guessedCharList.contains(new Character(c))) {
            JOptionPane
                    .showMessageDialog(null, "You already give that answer!");
            guess();
        }

        guessedCharList.add(new Character(c));

        if (rndWord.contains(c + "")) {
            validCharList.add(new Character(c));
            return c + "";
        } else {
            numberOfWrongGuess++;
            return "";
        }
    }
}