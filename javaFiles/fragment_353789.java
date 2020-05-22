public class Rounding {

    public static BigDecimal round(BigDecimal value, int prec) {
        return value.round(new MathContext(prec));
    }

    public static long round(long value, int prec) {
        return new BigDecimal(value).round(new MathContext(prec)).longValue();
    }

    public static double round(double value, int prec) {
        return new BigDecimal(value).round(new MathContext(prec)).doubleValue();
    }
}