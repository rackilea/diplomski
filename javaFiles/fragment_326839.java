java.util.Calendar cal = java.util.Calendar.getInstance();
cal.setTime(currentDate);
if (inDays) {
  cal.add(Calendar.DATE, -n);
} else if (inWeeks) {
  cal.add(Calendar.WEEK_OF_YEAR, -n);
} else if (inMonths) {
  cal.add(Calendar.MONTH, -n);
}