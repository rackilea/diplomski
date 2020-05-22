public static Date getDate(String dateString) {
  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
  formatter.setTimeZone(TimeZone.getTimeZone("PST"));
  try {
    return formatter.parse(dateString);
  } catch (ParseException e) {
    logger.error("error while parsing milliseconds to date" + dateString, e);
  }
  return null;
}