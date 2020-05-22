DecimalFormat decimalFormat = new DecimalFormat();
DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
decimalFormatSymbols.setGroupingSeparator(',');
decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

System.out.println(decimalFormat.parse(str.replace(" ", "")));