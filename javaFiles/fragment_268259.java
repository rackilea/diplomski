public static boolean isDate(String text, String date_pattern) {
    String newDate = text.replace("T00:00:00", "");
    SimpleDateFormat formatter = new SimpleDateFormat(date_pattern);
    ParsePosition position = new ParsePosition(0);
    formatter.setLenient(false);
    return formatter.parse(newDate, position) != null;
}