calendar.set(2011, Calendar.MARCH, 13, 1, 0, 0);      
int millis =
    calendar.get(Calendar.MILLISECOND) +
    calendar.get(Calendar.SECOND) * 1000 +
    calendar.get(Calendar.MINUTE) * 60 * 1000 +
    calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000;
System.out.println(zone.getOffset(1, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK), millis));