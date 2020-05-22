public Calendar convertDateToServerTimeZone(Date dateTime, String timeZone) {
    Calendar userDefinedTime = Calendar.getInstance();
    userDefinedTime.setTime(dateTime);
    if(!TimeZone.getDefault().getID().equalsIgnoreCase(timeZone)) {
    System.out.println        ("original defined time: " + userDefinedTime.getTime().toString() + " on tz:" + timeZone);
    Calendar quartzStartDate = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
    quartzStartDate.set(Calendar.YEAR, userDefinedTime.get(Calendar.YEAR));
    quartzStartDate.set(Calendar.MONTH, userDefinedTime.get(Calendar.MONTH));
    quartzStartDate.set(Calendar.DAY_OF_MONTH, userDefinedTime.get(Calendar.DAY_OF_MONTH));
    quartzStartDate.set(Calendar.HOUR_OF_DAY, userDefinedTime.get(Calendar.HOUR_OF_DAY));
    quartzStartDate.set(Calendar.MINUTE, userDefinedTime.get(Calendar.MINUTE));
    quartzStartDate.set(Calendar.SECOND, userDefinedTime.get(Calendar.SECOND));
    quartzStartDate.set(Calendar.MILLISECOND, userDefinedTime.get(Calendar.MILLISECOND));
    System.out.println("adapted time for " + TimeZone.getDefault().getID() + ": " + quartzStartDate.getTime().toString());
    return quartzStartDate;
    } else {
    return userDefinedTime;
    }
}