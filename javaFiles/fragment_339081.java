import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Chars;

public final class Main {
    private static final String INPUT = "0a1b2c3d4e";
    private static final int REPS = 10000000;

    public static volatile String out;

    public static void main(String[] args) {
        System.err.println(removeNonDigits1(INPUT));
        System.err.println(removeNonDigits2(INPUT));
        System.err.println(removeNonDigits3(INPUT));
        System.err.println(removeNonDigits4(INPUT));
        System.err.println(removeNonDigits5(INPUT));

        long t0 = System.currentTimeMillis();
        for (int i = 0; i < REPS; ++ i) {
            out = removeNonDigits1(INPUT);
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < REPS; ++ i) {
            out = removeNonDigits2(INPUT);
        }
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < REPS; ++ i) {
            out = removeNonDigits3(INPUT);
        }
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < REPS; ++ i) {
            out = removeNonDigits4(INPUT);
        }
        long t4 = System.currentTimeMillis();
        for (int i = 0; i < REPS; ++ i) {
            out = removeNonDigits5(INPUT);
        }
        long t5 = System.currentTimeMillis();
        System.err.printf("removeNonDigits1: %d\n", t1-t0);
        System.err.printf("removeNonDigits2: %d\n", t2-t1);
        System.err.printf("removeNonDigits3: %d\n", t3-t2);
        System.err.printf("removeNonDigits4: %d\n", t4-t3);
        System.err.printf("removeNonDigits5: %d\n", t5-t4);
    }

    private static final String PATTERN_SOURCE = "[^0-9]+";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_SOURCE);

    public static String removeNonDigits1(String input) {
        return input.replaceAll(PATTERN_SOURCE, "");
    }

    public static String removeNonDigits2(String input) {
        return PATTERN.matcher(input).replaceAll("");
    }

    public static String removeNonDigits3(String input) {
        char[] arr = input.toCharArray();
        int j = 0;
        for (int i = 0; i < arr.length; ++ i) {
            if (Character.isDigit(arr[i])) {
                arr[j++] = arr[i];
            }
        }
        return new String(arr, 0, j);
    }

    public static String removeNonDigits4(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); ++ i) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String removeNonDigits5(String input) {
        List<Character> charList = Chars.asList(input.toCharArray());
        Predicate<Character> isDigit =
            new Predicate<Character>() {
                public boolean apply(Character input) {
                    return Character.isDigit(input);
                }
            };
        Iterable<Character> filteredList =
            Iterables.filter(charList, isDigit);
        return Joiner.on("").join(filteredList);
    }
}