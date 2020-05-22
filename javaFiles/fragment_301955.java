public Calendar convertDateToServerTimeZone(Date dateTime, String timeZone) {
    Calendar userDefinedTime = Calendar.getInstance();
    userDefinedTime.setTime(dateTime);
    if(!TimeZone.getDefault().getID().equalsIgnoreCase(timeZone)) {
      System.out.println("original defined time: " + userDefinedTime.getTime().toString() + " on tz:" + timeZone);

      Date translatedTime = DateBuilder.translateTime(userDefinedTime.getTime(), TimeZone.getDefault(), TimeZone.getTimeZone(timeZone));

      Calendar quartzStartDate = new GregorianCalendar();
      quartzStartDate.setTime(translatedTime);
      System.out.println("adapted time for " + TimeZone.getDefault().getID() + ": " + quartzStartDate.getTime().toString());
      return quartzStartDate;
    } else {
      return userDefinedTime;
    }
}