import java.util.Scanner;

public class WordScrambler {

    public String prefix, inner, postfix, newword;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        WordScrambler wordScrambler = new WordScrambler();
        wordScrambler.scrambler(words);

    }

    public void scrambler(String words) {

        String[] word = words.trim().split(" ");

        for (int i = 0; i < word.length; i++) {

            System.out.println(word[i]);
        }
    }
}