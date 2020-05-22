DecimalFormat df = new DecimalFormat();
DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setDecimalSeparator('.');
symbols.setGroupingSeparator(',');
df.setDecimalFormatSymbols(symbols);
Number number = df.parse(str);