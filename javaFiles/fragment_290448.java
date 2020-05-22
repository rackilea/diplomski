private static BigDecimal round(BigDecimal input, int multiple) {
    return input.divide(new BigDecimal(multiple))
            .setScale(0, RoundingMode.CEILING)
            .multiply(new BigDecimal(multiple));
}

for (double i = 0; i < 10; i += 0.9) {
    System.out.println(String.format("%.1f => %s", i, round(new BigDecimal(i), 5)));
}