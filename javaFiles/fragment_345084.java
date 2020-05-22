public final class Utils {
 private static String nahodnaCisla;
 public static String get(int pocetCislic) {
   Random random = new Random();
    String nahodnaCislice;
    int jedenCyklus = 0;


    while(pocetCislic>jedenCyklus)
    {
        nahodnaCislice = String.valueOf(random.nextInt(10 - 0) + 0);
        nahodnaCisla = nahodnaCisla + nahodnaCislice;

        jedenCyklus++;
    }

    return nahodnaCisla;
  } 
}