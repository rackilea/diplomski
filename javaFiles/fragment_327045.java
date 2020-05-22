package stackoverflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

public final class Q11554180 {

    private Q11554180() {
    }

    //
    // (3) The same as item (1) however we're       ------------------------------------------------+
    //     capturing the group to get the class                                                     |
    //     name only                                                                                |
    // (2) At least one package name is required    ---------------------------------+              |
    // (1) We're searching valid package names only -----------------+               |              |
    //     and we do not need to capture it ?:                       |               |              |
    //                                              +----------------+--------------+|+-------------+-------------+
    //                                              |                               |||                           |
    private static final Pattern pattern = compile("(?:[\\p{Alpha}_][\\p{Alnum}_]*\\.)+([\\p{Alpha}_][\\p{Alnum}_]*)", CASE_INSENSITIVE);

    private static void find(CharSequence s) {
        final Matcher matcher = pattern.matcher(s);
        while ( matcher.find() ) {
            out.println(matcher.group(1));
        }
    }

    public static void main(String[] args) {
        find("class gqlMain.Node; class gqlMain.p1.NodeA");
        find("class gqlMain.p1.p11.NodeB");
        find("class gqlMain.p1.p11.p111.NodeC");
        find(Q11554180.class.getCanonicalName());
    }

}