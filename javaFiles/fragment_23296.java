import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
public class JavaMain {
    public static void main(String[] args) {
        String numberString = "2.105,88";
        //using casting
        try {
            DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
            df.setParseBigDecimal(true);
            BigDecimal bd = (BigDecimal) df.parseObject(numberString);
            System.out.println(bd.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //your way short version
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
        try {
            BigDecimal bd1 = new BigDecimal(nf.parse(numberString).toString());
            System.out.println(bd1.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String numberStringFixed = "2105.88";
        //direct string formated
        System.out.println(new BigDecimal(numberStringFixed));;     
        //direct but erroneous way if the string is not formated
        System.out.println(new BigDecimal(numberString));;

    }
}