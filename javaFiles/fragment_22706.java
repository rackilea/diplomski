import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DecimalFormatTest {

    public static void main(String[] args) throws ParseException {

        // use system default locale:
        // NumberFormat format = DecimalFormat.getInstance();

        // or specify the locale explicitly:
        NumberFormat format = DecimalFormat.getInstance(new Locale("es", "VE"));

        String text = "123.456,01" ;
        double value = format.parse(text).doubleValue();
        System.out.println("Parsed value as double: " +value);
        System.out.println("Value formatted again as text: " + format.format(value));
    }

}