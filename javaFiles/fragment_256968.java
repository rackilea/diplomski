import java.util.*;

class TimeZoneTest {
  public static void main(String[] args) {
    System.setProperty("user.timezone", "UTC");
    System.out.println(new Date());
  }
}