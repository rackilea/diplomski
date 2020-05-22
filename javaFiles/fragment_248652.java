public static Date parseDate(String dateToParse) {
    String[] dateFormats = {"h aaa z d MMM yy", "h:m aaa z d MMM yy"};

    for (String dateFormat : dateFormats) {
        try {
            return new SimpleDateFormat(dateFormat).parse(dateToParse);
        }
        catch (ParseException e) {

        }
    }
    return null;
}