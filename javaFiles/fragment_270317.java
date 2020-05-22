import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        int foundCount = 0;
        Scanner enter = new Scanner(System.in);
        String word_to_search = "home";
        char[] pad = new char[word_to_search.length()];
        Arrays.fill(pad, '_');
        StringBuilder word_do_display = new StringBuilder();
        word_do_display.append(pad);

        System.out.println(word_do_display);
        System.out.println();

        for(int i=0;i<9;i++) {
            System.out.print("Enter your letter : ");
            char user_input_letter = enter.next().charAt(0);

            // Look for whether the entered letter exists in the word, and replace the placeholders with the occurrences of the letter
            boolean found = false;
            int letterIndex = -1;
            while ((letterIndex = word_to_search.indexOf(user_input_letter, letterIndex + 1)) >= 0) {
                found = true;
                foundCount++;
                word_do_display.setCharAt(letterIndex, word_to_search.charAt(letterIndex));
            }
            if (found) {
                System.out.println("The letter exists !!");
                System.out.println(word_do_display);
            } else {
                System.out.println("This letter does not exist ! ");
            }
            if (foundCount == word_to_search.length()) {
                System.out.println("You win!");
                break;
            }
        }
        if (foundCount < word_to_search.length()) {
            System.out.println("You lost!");
        }
    }
}