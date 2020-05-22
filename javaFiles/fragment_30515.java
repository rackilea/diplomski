/** This gives me numeric value to the tenth (i.e. 6.1) */
public static double round(double unrounded) {
    BigDecimal bd = new BigDecimal(unrounded);
    BigDecimal rounded = bd.setScale(1, BigDecimal.ROUND_CEILING);
    return rounded.doubleValue();
}