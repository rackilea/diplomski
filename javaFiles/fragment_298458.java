import java.util.Locale;

public class Main {

  public static void main(String [] argv) {

    Locale defaultLocale = Locale.getDefault();
    System.out.println(defaultLocale.getDisplayCountry()); // displays United States
  }
}