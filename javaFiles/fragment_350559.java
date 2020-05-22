public XMLGregorianCalendar getDate(final XMLGregorianCalendar date, final XMLGregorianCalendar time) {

XMLGregorianCalendar date = null;
if (date != null && time != null) {
  try {
    newDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date.getYear(), date.getMonth(),     date.getDay(),
    time.getHour(), time.getMinute(), time.getSecond(), time.getMillisecond(), 0);
    Duration duration = DatatypeFactory.newInstance().newDurationDayTime(true, 0, 13, 0, 0);
    newDate.add(duration);
  }
  catch (Exception e) {
    LOGGER.error("Error creating date", e);
  }
}
return newDate;