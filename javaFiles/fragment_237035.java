import java.util.*;

public class WordIntMap {
    public static void main(String[] args) {
        HashMap<String, Integer> text = new HashMap<String, Integer>();
        String word = "hell";
        char myChar = 'o';
        int value = 1234;

        String key = word + myChar;

        if (text.get(key) != null) {
            text.put(key, value);
        }
    }
}