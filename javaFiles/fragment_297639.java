public static void main(String[] args) {
    BigDecimal bd = new BigDecimal(1);
    BigDecimal bd2 = new BigDecimal(3);

    BigDecimal result = bd.divide(bd2, MathContext.DECIMAL32);
    System.out.println(result);
    result = bd.divide(bd2, MathContext.DECIMAL64);
    System.out.println(result);
    result = bd.divide(bd2, MathContext.DECIMAL128);
    System.out.println(result);
    result = bd.divide(bd2, MathContext.UNLIMITED);
    System.out.println(result);
}