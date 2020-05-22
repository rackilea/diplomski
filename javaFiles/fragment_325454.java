package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    // working Pattern
    private static final Pattern PATTERN = Pattern.compile("^((1[234579])|42)");
    // Your Pattern won't work because although it takes in account the start of the 
    // input, the OR within a character class does not exempt you to write round brackets 
    // around sequential characters such as "12". 
    // In fact here, the OR will be interpreted as the "|" character in the class, thus 
    // allowing it as a start character.
    private static final Pattern NON_WORKING_PATTERN = Pattern.compile("^[12|13|14|15|17|19|42]");
    private static final String STARTS_WITH_1_234 = "8472952424";
    private static final String STARTS_WITH_ANYTHING_ELSE = "847295XXXX";

    public static void main(String[] args) {
        // NON_WORKING_PATTERN "works" on "33333"
        System.out.println(NON_WORKING_PATTERN.matcher("33333").find());
        int[] testIntegers = new int[]{1200, 1300, 1400, 1500, 1700, 1900, 4200, 0000};
        List<String> results = new ArrayList<String>();
        for (int test: testIntegers) {
            if (PATTERN.matcher(String.valueOf(test)).find()) {
                results.add(STARTS_WITH_1_234);
            }
            else {
                results.add(STARTS_WITH_ANYTHING_ELSE);
            }
        }
        System.out.println(results);
    }
}