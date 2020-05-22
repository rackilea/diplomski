import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    Double d1 = 1.3;
    BigDecimal bd1 = BigDecimal.valueOf(d1.doubleValue());
    Double d2 = bd1.doubleValue();
    System.out.println(d2);
  }
}