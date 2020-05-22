import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    double d1 = 0.4;
    double d2 = 0.400000000000000000001;
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(new BigDecimal(d1));
  }
}