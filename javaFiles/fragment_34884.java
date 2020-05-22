TimeZone zone = TimeZone.getTimeZone("America/New_York");
Calendar calendar = new GregorianCalendar(zone);
int hour = calendar.get(Calendar.HOUR_OF_DAY);
if (hour < 1 || hour >= 14) {
    ...
}