DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator('\'');
symbols.setDecimalSeparator(',');

DecimalFormat decimalFormat = new DecimalFormat("€ #,###.00", symbols);
String prezzo = decimalFormat.format(number);