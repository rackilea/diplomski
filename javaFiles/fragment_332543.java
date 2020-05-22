public static String getLastWeekDateForDay(String date, int offset, DayOfWeek dayOfWeek) {
    return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE)
                    .with(TemporalAdjusters.nextOrSame(dayOfWeek))
                    .minusWeeks(offset)
                    .format(DateTimeFormatter.BASIC_ISO_DATE);
}