import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    double baseDouble = Integer.MAX_VALUE;
    double minus1Double = Integer.MAX_VALUE - 1;
    double minus2Double = Integer.MAX_VALUE - 2;
    BigDecimal baseBD = new BigDecimal(Integer.MAX_VALUE);
    BigDecimal minus1BD = new BigDecimal(Integer.MAX_VALUE - 1);
    BigDecimal minus2BD = new BigDecimal(Integer.MAX_VALUE - 2);
    System.out.println("base " + baseDouble + " " + baseBD);
    System.out.println("minus1 " + minus1Double + " " + minus1BD);
    System.out.println("minus2 " + minus2Double + " " + minus2BD);
    System.out.println("Double base/minus1 " + baseDouble / minus1Double);
    System.out.println("Double minus1/minus2 " + minus1Double / minus2Double);
    System.out.println("BigDecimal base/minus1 "
        + baseBD.divide(minus1BD, 40, BigDecimal.ROUND_HALF_EVEN));
    System.out.println("BigDecimal minus1/minus2 "
        + minus1BD.divide(minus2BD, 40, BigDecimal.ROUND_HALF_EVEN));
  }
}