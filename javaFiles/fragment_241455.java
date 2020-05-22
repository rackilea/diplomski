import java.util.regex.Matcher;
import java.util.regex.Pattern;

// (incomplete) list of currency symbols, enhance from http://www.unicode.org/charts/PDF/U20A0.pdf
private static final String CURRENCY_SYMBOLS= "\\p{Sc}\u0024\u060B";

public static void main(String[] args) {
    Pattern p = Pattern.compile("[" +CURRENCY_SYMBOLS + "][\\d,]+");

    Matcher m = p.matcher("I got a wristwatch for $500 and i could sell it to a Nigerian for " +
            "₦13,000 or to someone in Saudi Arabia for ﷼800 or Afghanistan for ؋350");

    while (m.find()) {
        System.out.println(m.group());
    }
 }
}

//Output is:
// $500
// ₦13,000
// ﷼800
// ؋350