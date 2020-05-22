import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
public static void main(String[] args) {
    String userKey = "Amount";
    System.out.println("Full string matched: " + getMatch(userKey));

    userKey = "total";
    System.out.println("Full string matched: " + getMatch(userKey));
}

private static String getMatch(String key) {
    // Case: Getting full string for userKey (case insensitive) matches
    Pattern p1 = Pattern.compile(String.format("(?i)(.*%s.*\\s?.*:\\s*?\\$.*)", key));
    Matcher matcher1 = p1.matcher("Total Amount: $1,000");
    if (matcher1.matches()) {
        return matcher1.group(1);
    }
    return "";
}
}