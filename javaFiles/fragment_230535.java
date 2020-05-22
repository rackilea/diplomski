public String getDayOfWeek(int day, int firstDay) {
   String[] weekdays;
   if (firstDay == 0)
      weekdays = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
   else
      weekdays = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   return weekdays[day];
}