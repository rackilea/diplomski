private static Date getFirstThursday(Date now) {
  Calendar cal = Calendar.getInstance();
  cal.setTime(now);
  cal.set(Calendar.WEEK_OF_MONTH, 1);
  cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

  return cal.getTime();
}