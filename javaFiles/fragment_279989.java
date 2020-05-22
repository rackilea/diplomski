/*
 * Lab to perform different functions on Strings
 * all methods are static
 * only two methods should be public
 * all other methods are internal (only used in the class)
 */

package stringutil;

/**
 * @author [REDACTED]
 */

public class StringUtil {

    public static boolean inOut(String input) {// the argument is in main
        int len = input.length();
        boolean test;

        input = input.toLowerCase();

        // call the cleaners
        input = StringUtil.cleanse(input, len - 1);

        // this is le final product
        String reverse = StringUtil.flip(input);
        test = input.equals(reverse);

        return test;
    }

    private static String cleanse(String raw, int count) {
        if (count < 0)
            return raw;
        // this means that there was invalid punctuation
        else {
            char ch;
            ch = raw.charAt(count);

            if (ch >= 97 && ch <= 122 || ch >= 48 && ch <= 57) {
                // call method again with count-1 | string is same
                return cleanse(raw, count - 1);
            } else { // character ain't ok yo
                raw = raw.substring(0, count).concat(raw.substring(count + 1));
                return cleanse(raw, count - 2);
            }
        }
    }

    public static String flip(String input) {
        String newer;
        // base case
        if (input.length() == 1) {
            return input;
        } else {
            // take the last letter and make it the new start
            newer = input.substring(input.length() - 1);
            input = input.substring(0, input.length() - 1);
            return newer + flip(input);
        }
        // input = newer +
        // flip(input.substring(0, input.length()-1));
    }

    /**
     * 
     * @param args
     *            the command line arguments
     * 
     */

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(StringUtil.flip("aashf"));
        System.out.println(StringUtil.inOut("what, t;ahw"));
    }
}