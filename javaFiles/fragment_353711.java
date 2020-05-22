Calendar gmtTime = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
Date dateHeader = RFC1123Format.parse(date);
gmtTime.setTime(dateHeader);

Calendar currentTime = Calendar.getInstance();
currentTime.setTimeInMillis(System.currentTimeMillis());
boolean DST = false;
if(currentTime.getTimeZone().inDaylightTime(currentTime.getTime())) {
    DST = true; 
}
currentTime.setTimeZone(TimeZone.getTimeZone("GMT"));
if(DST) { 
    currentTime.set(Calendar.HOUR_OF_DAY, currentTime.get(Calendar.HOUR_OF_DAY) + 1); 
    .
    .
    .
    <code to handle last day of month and month change as a result of the hour adjustment>
}