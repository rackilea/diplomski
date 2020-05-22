import java.math.*;
class decimal {
    public static void main(String[] args) {
BigDecimal result = new BigDecimal(0);
BigDecimal v1 = new BigDecimal(10);
BigDecimal v2 = new BigDecimal(3);
result = v1.divide(v2,2,BigDecimal.ROUND_HALF_UP);
System.out.println(result);
}
}