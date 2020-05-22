Calendar mCalendar = new GregorianCalendar();
TimeZone mTimeZone = mCalendar.getTimeZone();
System.out.println("TimeZone: "+mTimeZone);
int mGMTOffset = mTimeZone.getRawOffset();
if (mTimeZone.inDaylightTime(mCalendar.getTime())){
    mGMTOffset += mTimeZone.getDSTSavings();
}
System.out.printf("GMT offset is %s hours", 
TimeUnit.HOURS.convert(mGMTOffset, TimeUnit.MILLISECONDS));