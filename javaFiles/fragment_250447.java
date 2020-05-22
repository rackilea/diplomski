import java.math.BigDecimal;

public class Test
{
  public static void main(String[] args) {
    double maxValue = (double)Long.MAX_VALUE;
    System.out.println(new BigDecimal(maxValue));
    double nextDown = Math.nextAfter(maxValue, 0);
    System.out.println(new BigDecimal(nextDown));
    System.out.println(maxValue-nextDown);
  }
}