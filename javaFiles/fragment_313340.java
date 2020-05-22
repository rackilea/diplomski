LocalDate now = LocalDate.now();
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    .appendPattern("[uuuu[-MM[-dd]]]")
    .parseDefaulting(ChronoField.YEAR, now.getYear())
    .parseDefaulting(ChronoField.MONTH_OF_YEAR, now.getMonthValue())
    .parseDefaulting(ChronoField.DAY_OF_MONTH, now.getDayOfMonth())
    .toFormatter();
System.out.println(LocalDate.parse("2015-06-30", fmt));
System.out.println(LocalDate.parse("2015-06", fmt));
System.out.println(LocalDate.parse("2015", fmt));
System.out.println(LocalDate.parse("", fmt));