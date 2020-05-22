//month should be 0-based, i.e. use 11 for December
static Date getLastThursday(int month, int year) {
  Calendar cal = Calendar.getInstance();
  cal.set(year, month + 1, 1);
  cal.add(Calendar.DAY_OF_MONTH, -((cal.get(Calendar.DAY_OF_WEEK) + 2) % 7));
  if (cal.get(Calendar.MONTH) != month) cal.add(Calendar.DAY_OF_MONTH, -7);
  return cal.getTime();
}