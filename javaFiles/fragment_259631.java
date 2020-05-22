final DecimalFormat f = new DecimalFormat("#,###.000");
final DecimalFormatSymbols s = new DecimalFormatSymbols();
s.setGroupingSeparator(' ');
s.setDecimalSeparator('.');
f.setDecimalFormatSymbols(s);
final double input = 1_555_005;
final BigDecimal x = new BigDecimal(input).scaleByPowerOfTen(-3);
System.out.println(f.format(x));