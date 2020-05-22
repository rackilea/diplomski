// default symbols for the locale
DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
// set your required separator
decimalFormatSymbols.setDecimalSeparator(',');
// create a decimal format and set your symbols
DecimalFormat format = new DecimalFormat();
format.setDecimalFormatSymbols(decimalFormatSymbols);