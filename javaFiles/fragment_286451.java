public static String toUtcDate(String dateStr) {
    SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    // Add other parsing formats to try as you like:
    String[] dateFormats = {"yyyy-MM-dd", "MMM dd, yyyy hh:mm:ss Z"}; 
    for (String dateFormat : dateFormats) {
        try {
            return out.format(new SimpleDateFormat(dateFormat).parse(dateStr));
        } catch (ParseException ignore) { }
    }
    throw new IllegalArgumentException("Invalid date: " + dateStr);
}