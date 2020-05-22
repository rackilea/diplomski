// Create a DecimalFormat that fits your requirements
DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator(',');
symbols.setDecimalSeparator('.');
String pattern = "#,##0.0#";
DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
decimalFormat.setParseBigDecimal(true);

// parse the string
BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse("10,692,467,440,017.120");
System.out.println(bigDecimal);