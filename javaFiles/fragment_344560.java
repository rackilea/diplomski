public static void main(String[] args) {
    DecimalFormat formatter = new DecimalFormat();
    formatter.setMaximumFractionDigits(340);
    BigDecimal[] numbers = {new BigDecimal("100.0"), new BigDecimal("100.123"), new BigDecimal("100.123456789012345")};
    for (BigDecimal number : numbers) {         
        System.out.println(formatter.format(number));
    }
}