import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ShortestPalindrome {
    public static int isShortestPalindrome(ArrayList<String> list) {
        // Sorts the given ArrayList by length
        Collections.sort(list, Comparator.comparingInt(String::length));
        for (String element : list) {
            if(isPalindrome(element)) {
                return element.length();
            }
        }
        return -1; // If there is no palindrome in the given array
    }

    private static boolean isPalindrome(String input) {
        String lowerCased = input.toLowerCase();
        int pre = 0;
        int end = lowerCased.length() - 1;
        while (end > pre) {
            if (lowerCased.charAt(pre) != lowerCased.charAt(end))
                return false;
            pre ++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("malayam", "aba", "abcdeyugugi", "nitin"));
        int size = isShortestPalindrome(array);
        System.out.println("Shortest length of string in list: " + size);
    }
}