import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Sample class to demonstrate recursion
 * @author vmarche
 */
public class WordCount {

    public static void main (String [] args) {

        // Infinite loop
        while (true) {

            System.out.println("Please enter a sentence:");
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            try {
                String input = keyboard.readLine();
                int count = countWords(input);
                System.out.println("Number of words: " + count);
            }

            catch (Exception e) {
                System.exit(0);
            }
        }
    }

    /**
     * Counts the words in a sentence recursively
     * @param sentence      The input sentence
     * @return              The number of words
     */
    public static int countWords (String sentence) {

        if (sentence.isEmpty())
        return 0;

        // Find the first index of a space
        int space = sentence.indexOf(" ");

        // If space exists, return count of sub-sentence
        if (space != -1)
            return 1 + countWords(sentence.substring(space + 1));
        // Else space does not exist, return 1
        else
            return 1;
    }
}