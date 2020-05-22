import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone {
    public static void main(String[] args) throws java.lang.Exception {
        String WORDS_GROUP = ",\n ";
        String text = "This is my sample     text";
        int wordCount = 0;
        boolean previousCharWasSpace = true;
        for (int i = 0; i < text.length(); i++) {
            boolean thisCharIsASpace = false;
            for (int j = 0; j < WORDS_GROUP.length(); j++) {
                if (text.charAt(i) == WORDS_GROUP.charAt(j)) {
                    previousCharWasSpace = true;
                    thisCharIsASpace = true;
                    break;
                }
                System.out.println("char=" + text.charAt(i) + " j=" + j
                        + " previousCharWasSpace=" + previousCharWasSpace);
            }
            if (!thisCharIsASpace && previousCharWasSpace) {
                wordCount++;
                previousCharWasSpace = false;
                System.out.println("char=" + text.charAt(i)
                        + " previousCharWasSpace=" + previousCharWasSpace
                        + " wordCount=" + wordCount);
            }
        }
        System.out.println("wordCount=" + wordCount);
    }
}