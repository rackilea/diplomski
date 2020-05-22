public static void main(String[] args) {
    Date date = new Date(1444817534489L); // 2015-10-14 10:12:14.489 UTC
    printDate(date, "UTC");
    printDate(date, "Australia/Sydney");
    printDate(date, "Europe/Moscow");
    printDate(date, "Europe/Berlin");
    printDate(date, "America/Fort_Wayne");
}
private static void printDate(Date date, String timeZoneID) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
    df.setTimeZone(timeZone);
    System.out.printf("%-20s %-30s inDaylightTime: %s%n", timeZoneID + ":",
                      df.format(date), timeZone.inDaylightTime(date));
}