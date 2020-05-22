public static boolean isDateInCurrentWeek(Date date) {
  Calendar currentCalendar = Calendar.getInstance();
  int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
  int year = currentCalendar.get(Calendar.YEAR);
  Calendar targetCalendar = Calendar.getInstance();
  targetCalendar.setTime(date);
  int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
  int targetYear = targetCalendar.get(Calendar.YEAR);
  return week == targetWeek && year == targetYear;
}