public static void main(String[] args) {
    BigDecimal seven = new BigDecimal(7);
    BigDecimal sevenWithDecimals = new BigDecimal("7.12");
    DecimalFormat decF = new DecimalFormat("#.000000");

    System.out.println(decF.format(seven.doubleValue()));
    System.out.println(decF.format(sevenWithDecimals.doubleValue()));
}