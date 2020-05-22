@Override
    public String convertToString(Object value, Locale locale) {
        NumberFormat fmt = getNumberFormat(locale);
        fmt.setMaximumFractionDigits(4); // By default this is 3.
        return fmt.format(value);
    }