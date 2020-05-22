import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Palindrome {
    public static void main(String... args) {
        // Request for input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your sentence...");

        // Read the user input
        String sentence = reader.nextLine();

        // Split the sentence (into tokens) at spaces and special characters using regex
        // Keep the special characters where they are and form a List with the split words
        List<String> tokens = Arrays.asList(sentence.split("((?<=[\\?,\\. ])|(?=[\\?,\\. ]))"));

        // For every token/word, form the palindrome of that and then join them back
        String result = tokens.stream().map(s -> formPalindrome(s)).collect(Collectors.joining());

        // This is the final result
        System.out.println("result: " + result);

        reader.close();
    }

    private static String formPalindrome(String str) {
        // Reverse the String
        String reversed = new StringBuilder(str).reverse().toString();

        // String length
        int strLen = reversed.length();

        // Compare each character of reversed string with last character of the string until they are different
        // When they are different concat the substring with original string
        for (int i = 0; i < strLen; i++) {
            if (reversed.charAt(i) != str.charAt(strLen - 1)) {
                return str + reversed.substring(i);
            }
        }

        return str;
    }
}