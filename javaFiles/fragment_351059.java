public static final BigDecimal convertToBigDecimal(String stringNumber1, String stringNumber2, char separator, char groupingSeparator)
            throws ParseException {
        Locale myLocale = Locale.FRANCE;
        DecimalFormatSymbols decimalSeparator = new DecimalFormatSymbols(myLocale);
        decimalSeparator.setDecimalSeparator(separator);
        decimalSeparator.setGroupingSeparator(groupingSeparator);
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(myLocale);
        format.setDecimalFormatSymbols(decimalSeparator);

        Number number1 = format.parse(stringNumber1.trim());
        Number number2 = format.parse(stringNumber2.trim());
        double substractResult = number1.doubleValue() - number2.doubleValue();

        // If you want back a String presentation => String stringFormat = "" +
        // substractResult;

        return new BigDecimal(substractResult);
    }