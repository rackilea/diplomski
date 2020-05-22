// Possibly...
public Date toDate(XMLGregorianCalendar date) {
    TimeZone zone = TimeZone.getTimeZone("America/New_York");
    Calendar calendar = date.toGregorianCalendar(zone, Locale.US, null);
    return calendar.getTime();
}