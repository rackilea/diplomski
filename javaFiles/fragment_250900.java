import java.util.Arrays;
import java.util.regex.Pattern;

public class PatternMatcherFind {

    // ^                - String starts with
    // [A-Fa-f0-9]{6}   - 6 chars long color literal
    // |                - or
    // [A-Fa-f0-9]{3}   - 3 chars long color literal
    private static final String STARTS_WITH_COLOR_LITERAL = "^[A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}";
    private static final Pattern pattern = Pattern.compile(STARTS_WITH_COLOR_LITERAL);

    public static void main(String[] args) {
        String stringToSearch = "we have got white #ffffff and black #000000 wohooo!";
        Arrays.stream(stringToSearch.split("#"))               // splitting on "#" will create array [ "we have got white ", "ffffff and black ", "000000 wohooo!" ]
                .skip(1)                                       // we may omit first one as it would never start with color literal
                .filter(part -> pattern.matcher(part).find())  // we keep only those Strings which starts with color literal
                .forEach(System.out::println);                 // may print them or whatever
    }
}