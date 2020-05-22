import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

public static void main(String[] args) {
    // Case1: Getting full string
    Pattern p1 = Pattern.compile("(.*\\s?.*:\\s?\\$.*)");
    Matcher matcher1 = p1.matcher("Total Amount: $1,000");
    if (matcher1.matches()) {
        System.out.println("Full string matched: " + matcher1.group(1));
    }

    // Case2: Getting only the amount of dollars
    Pattern p2 = Pattern.compile(".*\\s?.*:\\s?\\$?(.*)");
    Matcher matcher2 = p2.matcher("Total Amount: $1,000");
    if (matcher2.matches()) {
        System.out.println("Amount only from matched string: " + matcher2.group(1));
    }
}
}