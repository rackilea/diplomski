package your.packagename;
// http://code.google.com/p/guava-libraries
import static com.google.common.base.Preconditions.*;

public class YourClass {

    public static String getDayOfMonthSuffix(String num) {
        Integer n = Integer.valueOf(num == null ? "1" : num);
        checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
}