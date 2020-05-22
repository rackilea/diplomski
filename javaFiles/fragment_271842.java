private static Date getDate(String timestamp, SimpleDateFormat dateFormat) {
    Date date = null;
    try {
        date = dateFormat.parse(timestamp);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return date;
}

private static String createString(String[] contents, String separator) {
    StringBuilder builder = new StringBuilder();
    for (String content : contents) {
        builder.append(content).append(separator);
    }
    builder.deleteCharAt(builder.length()-separator.length());

    return builder.toString();
}

private static String formatTimeZone(String timeZone) {
    String[] timeZoneSplits = timeZone.split(":");
    DecimalFormat formatter = new DecimalFormat("+##;-#");
    formatter.setMinimumIntegerDigits(2);

    timeZoneSplits[0] = formatter.format(Integer.parseInt(timeZoneSplits[0]));
    return createString(timeZoneSplits, ":");
}