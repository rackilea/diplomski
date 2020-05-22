import java.util.*;
import java.util.Locale;
public class Donors {
    public static void main (String [] args) {
        for (final String code : Locale.getISOCountries()) {
            System.out.println (code);
        }
    }
}