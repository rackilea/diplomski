import java.util.*;

public class SameChars {

    // Logic to convert the string to a set
    public static Set<Character> stringToCharSet(String str) {
       Set<Character> charSet = new HashSet<Character>();
       char arrayChar[] = str.toCharArray();
       for (char aChar : arrayChar) {
          charSet.add(aChar);
       }

       return charSet;
    }

    // Compares the two sets
    public static boolean hasSameChars(String str1, String str2) {
       return stringToCharSet(str1).equals(stringToCharSet(str2));
    }

    public static void main(String args[]){
        // Should return true
        System.out.println(hasSameChars("hello", "olleh"));
        // Should returns false
        System.out.println(hasSameChars("hellox", "olleh"));
    }

}