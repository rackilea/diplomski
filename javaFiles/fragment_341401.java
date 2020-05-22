import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
public class DecimalFormatDemo {

   static public void customFormat(String pattern, double value ) {

    NumberFormat nf1 = NumberFormat.getNumberInstance(Locale.ENGLISH);
    DecimalFormat df1 = (DecimalFormat)nf1;
    df1.applyPattern(pattern);
    String output = df1.format(value);
    System.out.println("Input: " + value + ", pattern: " + pattern + " output: " + output);


    NumberFormat nf2 = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df2 = (DecimalFormat)nf2;
    df2.applyPattern(pattern);
    output = df2.format(value);
    System.out.println("Input: " + value + ", pattern: " + pattern + " output: " + output);

  }

  static public void main(String[] args) {
    customFormat("###,###.###", 123456.789);
   }
}