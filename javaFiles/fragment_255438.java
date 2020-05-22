private static String format(BigDecimal x, int scale) {
  NumberFormat formatter = new DecimalFormat("0.0E0");
  formatter.setRoundingMode(RoundingMode.HALF_UP);
  formatter.setMinimumFractionDigits(scale);
  return formatter.format(x);
}
...
System.out.println(format(new BigDecimal("0.00001"), 2)); // 1.00E-5
System.out.println(format(new BigDecimal("0.00001"), 3)); // 1.000E-5