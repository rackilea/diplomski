import java.text.NumberFormat;
import java.util.Locale;

public class NumToword {
   public static void main(String str[]){
        String outputString = new String();
       Locale[] thaiLocale = {
                    new Locale("th"),
                    new Locale("th", "TH"),
                    new Locale("th", "TH", "TH")
                };
       for (Locale locale : thaiLocale) {
           NumberFormat nf = NumberFormat.getNumberInstance(locale);
           outputString = outputString + locale.toString() + ": ";
            outputString = outputString + nf.format(573.34) + "\n";
       }
       System.out.println(outputString);
   }
  }