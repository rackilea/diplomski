public final BigDecimal convertToBigDecimal(String stringNumber1, String stringNumber2)
            throws ParseException {
        return convertToBigDecimal(stringNumber1, stringNumber2, ',', '.');
    }

    public final BigDecimal convertToBigDecimal(String stringNumber1, String stringNumber2, char separator)
            throws ParseException {
        return convertToBigDecimal(stringNumber1, stringNumber2, separator, '.');
    }