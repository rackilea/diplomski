static boolean parse(String date, String format) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    try {
        YearMonth.parse(date, formatter);
    } catch (DateTimeParseException e) {
        return false;
    }
    return true;
}