public static List<LocalDate> getDaysOfYear(int year, List<LocalDate> holidays) {

  LocalDate date = new LocalDate(year, 1, 1);
  LocalDate end = new LocalDate(year + 1, 1, 1);
  List<LocalDate> list = new ArrayList<LocalDate>();

  while (date.isBefore(end)) {
    if (!holidays.contains(date)) {
      list.add(date);
    }
    date = date.plusDays(1);
  }

  return Collections.unmodifiableList(list);
}