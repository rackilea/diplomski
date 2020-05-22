DecimalFormat decimalFormat = new DecimalFormat();
decimalFormat.setGroupingSize(3);
DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
decimalFormatSymbols.setGroupingSeparator('.');
decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
System.out.println(decimalFormat.format(value));