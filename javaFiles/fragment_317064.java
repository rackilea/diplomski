import java.math.BigDecimal;

public class BigDecimalScale {
  public static void main(String... args) {
    long base = 12345;
    int scale = 4;

    BigDecimal number = BigDecimal.valueOf(base, scale);
    System.out.println(number);
    BigDecimal pointRight = number.movePointRight(5);
    System.out.println(pointRight + "; my scale is " + pointRight.scale());
    BigDecimal scaleBy = number.scaleByPowerOfTen(5);
    System.out.println(scaleBy + "; my scale is " + scaleBy.scale());
  }
}