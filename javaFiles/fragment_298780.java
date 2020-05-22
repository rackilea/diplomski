public static String getNextDate(String  curDate) {
  final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
  final Date date = format.parse(curDate);
  final Calendar calendar = Calendar.getInstance();
  calendar.setTime(date);
  calendar.add(Calendar.DAY_OF_YEAR, 1);
  return format.format(calendar.getTime()); 
}