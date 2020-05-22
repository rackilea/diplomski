public class Test {
    public static void main(String[] args) throws java.lang.Exception {
        BigDecimal priceDiff = BigDecimal.ONE.subtract(new BigDecimal("9.99").divide(new BigDecimal("19.99"), MathContext.DECIMAL128))
                                             .multiply(new BigDecimal(100));
        System.out.println(priceDiff.toPlainString());
    }
}