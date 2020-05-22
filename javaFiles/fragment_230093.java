import java.util.Arrays;

class rTest {
  public static void main (String[] args) {
    String s = "119 days 6 hours 13 minutes 24 seconds";
    String[] parts = s.split("(?<![^a-zA-Z])\\s");
    System.out.println(Arrays.toString(parts));
  }
}