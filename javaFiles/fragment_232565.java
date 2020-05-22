import javax.swing.JOptionPane;

public class Palindromechkr {
    public static void main(String[] args) {
        //Declare Variables
        String Palin, input, Rinput = "";
        int wordlength, spacePos;
        //Ask for sentance
        input = JOptionPane.showInputDialog("enter a sentance");

        String[] words = input.split(" +"); // see regular expressions to understand the "+"
        for(int i = 0; i < words.length; i++) { // cycle through all the words in the array
            Rinput = makePalindrome(words[i]); // build the palindrome version of the current word using the recursive function

            if(Rinput.equalsIgnoreCase(words[i])) {
                Palin = words[i];
                System.out.println("Palin: " + Palin);
            }
        }
    }

    // this is the recursive function that build the palindrome version of  its parameter "word"
    public static String makePalindrome(String word) {
        if(word.length() <= 1) return word; // recursion base case

        char first = word.charAt(0); // get the first character
        char last = word.charAt(word.length()-1); // get the last character
        String middle = word.substring(1, word.length()-1); // take the "internal" part of the word
                                                            // i.e. the word without the first and last characters

        String palindrome = last + makePalindrome(middle) + first; // recursive call building the palindrome
        return palindrome; // return the palindrome word
    }
}