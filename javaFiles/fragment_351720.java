public class Main {

  public static String formatResult(float result) {
    return String.format( "%.2f", result);
  }

  public static void main(String args[]) {
    System.out.println(formatResult(37f));
  }
}