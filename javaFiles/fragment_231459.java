public static void main(String[] args) {
    BigDecimal result1 = (new BigDecimal(5).multiply(new BigDecimal("0.049"))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    BigDecimal result2 = (new BigDecimal(5).multiply(new BigDecimal(0.049))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    System.out.println(result1);
    System.out.println(result2);
}