public class TestMain {
  public static void main(String[] args) {
    long timeBefore = System.currentTimeMillis();
    for (int i = 0; i < 50000; i++) {
        System.out.println("Value = " + i);
    }
    long timeAfter = System.currentTimeMillis();
    System.out.println("Time elapsed (ms): " + (timeAfter - timeBefore));
  }
}