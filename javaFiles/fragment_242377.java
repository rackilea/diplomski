// Gets last Friday of the Month
// Need last Friday of previous Month...
public static String getLastFriday() {
    Calendar cal = new GregorianCalendar();
    // reduce the "current" month by 1 to get the "previous" month
    cal.set(GregorianCalendar.MONTH, cal.get(GregorianCalendar.MONTH) - 1); 
    cal.set(GregorianCalendar.DAY_OF_WEEK, Calendar.FRIDAY);
    cal.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, -1);        
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy/MM/dd");
    lastFriday = date_format.format(cal.getTime()); 
    return lastFriday;
}