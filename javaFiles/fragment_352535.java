import java.util.regex.Matcher;
import java.util.regex.Pattern;

// [...] 

public static final Pattern P = Pattern.compile("^(\\d [\\+\\-] )*\\d$");

public static void main(String[] args) {
    final String[] testCases = {
        "1+2", "2 + 3", "5 + 6 - 4", "1 + ", "6 6"
    };

    for(String s:testCases) {
        final Matcher m = P.matcher(s);
        if(m.matches()) {
            System.out.println("String valid: " + s);
        } else {
            System.out.println("String invalid: " + s);
        }
    }
}