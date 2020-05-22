public class Main {
  public static void main(String[] args) {
    int pauseDays = 90;
    long minus = pauseDays * 24 * 60 * 60 * 1000;
    System.out.println(minus);

    long pauseDaysL = 90L;
    long minusL = pauseDaysL * 24L * 60L * 60L * 1000L;
    System.out.println(minusL);
  }
}