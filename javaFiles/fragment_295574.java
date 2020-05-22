package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /* 
     * Pattern for a single numerical, starting with optional -/+ sign, 
     * followed by an unidentified length integer,
     * followed by optional "," separator and unidentified length integer, 
     * followed by optional "." separator and unidentified length integer decimals
     */
    private static final String SINGLE_NUMBER_PATTERN = "([\\+-]?\\d+(,\\d+)?(\\.\\d+)?)";
    /*
     * Pattern for range indicator. Note that "up to" is not intended here as a prefix.   
     */
    private static final String RANGE_INDICATOR_PATTERN = "(\\s?(-\\s|--|to|(up\\s?to))\\s?)";
    /*
     * Pattern combining one numerical, a range indicator, and another numerical. 
     * It starts with a negative look-behind reference to avoid starting the match if 
     * with preceded by a range indicator, and avoids ending the match if followed by a 
     * range indicator as well.  
     */
    private static final String RANGE_PATTERN = "(?<!"
            + RANGE_INDICATOR_PATTERN + ")" + SINGLE_NUMBER_PATTERN
            + RANGE_INDICATOR_PATTERN + SINGLE_NUMBER_PATTERN + "(?!"
            + RANGE_INDICATOR_PATTERN + ")";
    /*
     * Pattern defining a single number neither preceded nor followed by a range indicator.
     */
    private static final String ISOLATED_NUMBER_PATTERN = "(?<!"
            + RANGE_INDICATOR_PATTERN + ")" + SINGLE_NUMBER_PATTERN
            + "(?!" + RANGE_INDICATOR_PATTERN + ")";
    /*
     * Ultimate pattern combining single, isolated numbers and ranges. 
     */
    private static final String WHOLE_PATTERN = 
            "(" + ISOLATED_NUMBER_PATTERN + ")|(" + RANGE_PATTERN + ")";
    public static void main(String[] args) {
        // single numbers in various formats
        String singleNumbers = "0 -1000 30,000 3,000.00";
        // various ranges with various numerical formats
        String ranges = "0 to 1 1000- 2,000 30,000--40,000.00 4.00 up to 5 10,000 to -5";
        // mixed
        String mixed = "0 0 to 1 -1000 1000- 2,000 30,000 30,000--40,000.00 3,000.00 4.00 up to 5 10,000 to -5";
        // testing single numbers
        Pattern singleNumber = Pattern.compile(SINGLE_NUMBER_PATTERN);
        Matcher singleNumberMatcher = singleNumber.matcher(singleNumbers);
        while (singleNumberMatcher.find()) {
            System.out.println("SINGLE NUMBER: " + singleNumberMatcher.group());
        }
        // testing ranges
        Pattern rangesPattern = Pattern.compile(RANGE_PATTERN);
        Matcher rangesMatcher = rangesPattern.matcher(ranges);
        while (rangesMatcher.find()) {
            System.out.println("WHOLE RANGE: " + rangesMatcher.group());
            // note how tough it is to correctly guess group numbers
            // if you use Java 7 you can actually name your groups
            System.out.println("\tfirst number in range: "
                    + rangesMatcher.group(4));
            System.out.println("\tsecond number in range: "
                    + rangesMatcher.group(10));
        }
        // testing mixed examples
        Pattern mixedPattern = Pattern.compile(WHOLE_PATTERN);
        Matcher mixedMatcher = mixedPattern.matcher(mixed);
        while (mixedMatcher.find()) {
            System.out.println("WHOLE MATCH: " + mixedMatcher.group());
            if (mixedMatcher.group(1) != null) {
                System.out.println("\tsingle number: " + mixedMatcher.group(1));
            }
            else if (mixedMatcher.group(11) != null) {
                System.out.println("\trange: " + mixedMatcher.group(11));
                // note how CRAZY it is to correctly guess group numbers now!
                // if you use Java 7 you can actually name your groups
                System.out.println("\t\tfirst number in range: "
                        + mixedMatcher.group(15));
                System.out.println("\t\tsecond number in range: "
                        + mixedMatcher.group(21));
            }
        }
    }
}