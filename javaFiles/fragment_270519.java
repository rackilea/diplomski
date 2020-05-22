import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Set<Character> guesses = new HashSet<>();
        System.out.println(hideNonGuesses("apple", guesses));
        guesses.add('p');
        System.out.println(hideNonGuesses("apple", guesses));
        guesses.add('o'); // No change - it's not in the word
        System.out.println(hideNonGuesses("apple", guesses));
        guesses.add('a');
        System.out.println(hideNonGuesses("apple", guesses));
    }

    public static String hideNonGuesses(String input, Set<Character> guesses) {
        char[] result = input.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (!guesses.contains(result[i])) {
                result[i] = '-';
            }
        }
        return new String(result);
    }

}