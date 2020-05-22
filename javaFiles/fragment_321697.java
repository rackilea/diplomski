import java.text.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(parseCompleteString("12"));
        System.out.println(parseCompleteString("12abc"));
        System.out.println(parseCompleteString("abc12"));
    }

    public static Number parseCompleteString(String input) {
        ParsePosition pp = new ParsePosition(0);
        NumberFormat numberFormat = new DecimalFormat();
        Number result = numberFormat.parse(input, pp);
        return pp.getIndex() == input.length() ? result : null;
    }
}