public static void main(String[] args) throws Exception {
  DateTimeFormatter fmt = new DateTimeFormatterBuilder()
          .appendPattern("d/M/")
          .appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 2, LocalDate.now().minusYears(80))
          .toFormatter();
  parse("13/5/99", fmt);
  parse("13/5/36", fmt);
  parse("13/5/35", fmt);
  parse("13/5/34", fmt);
  parse("13/5/33", fmt);
}

private static void parse(String date, DateTimeFormatter fmt) {
  System.out.println(date + " = " + LocalDate.parse(date, fmt));
}