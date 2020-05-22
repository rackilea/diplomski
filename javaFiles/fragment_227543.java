import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String args[]) {
        Locale locales[] = SimpleDateFormat.getAvailableLocales();
        NumberFormat cfLocal = null;
        for (int i = 0; i < locales.length; i++) {
           cfLocal = NumberFormat.getCurrencyInstance(locales[i]); 
           System.out.println(locales[i].toString()+" "
           +locales[i].getDisplayName()+" "
           +locales[i].getDisplayCountry()+" "
           +cfLocal.format(1234567890.12));             
        }            
    }    
}