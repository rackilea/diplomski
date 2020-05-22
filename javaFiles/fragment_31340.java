import java.util.*;
import java.io.*;
public class StringSplitTest {
    private static List<String> words = new ArrayList<>();
    private static String word = "";
    private static boolean wordFlag = true;
    public static void main(String [] args) throws IOException {
        // Read file and create word tokens
        FileReader reader = new FileReader("test.txt");
        int c;
        while ((c = reader.read()) != -1) {
            makeWords((char) c);
        }
        reader.close();
        // Process tokens to get result
        int n = 0; // tracks count of words on a line
        List<String> line = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (i < 7) {
                // The first header line has 7 tokens
                // ignore for now
                continue;
            }
            // Process remaining lines (6 tokens for each line)
            if (++n == 7) {
                System.out.println(line); // prints a line
                n = 1;
                line = new ArrayList<>();
            }
            line.add(words.get(i));
        }
        System.out.println(line); // prints last line
    }
    /*
     * Processes all text (a character at a time and stores them as
     * word tokens in a List<String>. Uses whitespaces as delimiter.
     * NOTE: The whitespace as defined in the Character.isWhitespace()
     * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html.
     */
    private static void makeWords(char c) {
        if (! Character.isWhitespace(c)) {
            if (! wordFlag) {
                wordFlag = true;
                word = "";
            }
            word = word + String.valueOf(c);
        }   
        else {
            if (wordFlag) {
                wordFlag = false;
                words.add(word);
            }
        }
    }
}