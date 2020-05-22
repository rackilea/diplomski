private static String[] getDaysOfWeek() {
    String[] days = new String[6];
    DateTimeFormatter dayOfMonthFormatter = DateTimeFormatter.ofPattern("dd");
    LocalDate today = LocalDate.now(ZoneId.of("America/Montreal"));
    // go back to Sunday, then forward 1 day to get Monday
    LocalDate day = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
            .plusDays(1);
    days[0] = day.format(dayOfMonthFormatter);
    for (int i = 1; i < 6; i++) {
        day = day.plusDays(1);
        days[i] = day.format(dayOfMonthFormatter);
    }
    return days;
}