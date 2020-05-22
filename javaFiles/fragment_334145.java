public class Stargazing {
   public static void main(String args[]) {
      double planets = 840000;
      double numofsun = 2.5;
      double total = 0;
      System.out.printf("%8s %13s%n", "Galaxy #", "Planets");
      for (int i = 1; i < 12; i++) {
         double siSky = planets * numofsun;
         total += siSky;
         System.out.printf("%-8s %,13.2f%n", i + ":", total);
      }
   }
}