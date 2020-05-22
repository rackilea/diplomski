...
ResourceBundle r = LocaleData.getDateFormatData(loc);
if (!isGregorianCalendar()) {
    try {
        dateTimePatterns = r.getStringArray(getCalendarName() + ".DateTimePatterns");
    } catch (MissingResourceException e) {
    }
}
if (dateTimePatterns == null) {
    dateTimePatterns = r.getStringArray("DateTimePatterns");
}
...