public String toString() {
  StringBuilder builder = new StringBuilder();
  builder.append("Weekly Hours:   " + getWeeklyHours()));
  for(int i = 0; i < NUMDAYS; i++ ) {
    builder.append("        Day "  + (i + 1) + ": " + getHoursByDay(i)));
  }
  return builder.toString();
}