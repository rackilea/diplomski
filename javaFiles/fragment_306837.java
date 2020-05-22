static public String displayNumber(String startValue, Locale startLocale, Locale endLocale) throws ParseException {
    NumberFormat parser = NumberFormat.getNumberInstance(startLocale);
    NumberFormat formatter = NumberFormat.getNumberInstance(endLocale);

    Number rawNumber = parser.parse(startValue);

    return formatter.format(rawNumber);
}