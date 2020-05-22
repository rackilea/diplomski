static void printWeekNumber(DayOfWeek firstDayOfWeek, LocalDate date) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE uuuu-MM-dd", Locale.ENGLISH);
    final int daysPerWeek = DayOfWeek.values().length;

    // Week number according to your comment: “using the Temporal adjusters
    // I am getting the date on the last day of the week.
    // After that dividing the Day of the Year from the API by 7”
    DayOfWeek lastDayOfWeek = firstDayOfWeek.minus(1);
    int askersCommentWeekNumber = date
            .with(TemporalAdjusters.nextOrSame(lastDayOfWeek))
            .getDayOfYear()
                    / daysPerWeek;

    // My suggested way of calculating the same week number
    WeekFields customWeekFields = WeekFields.of(firstDayOfWeek, daysPerWeek);
    int customWeekNumber = date.get(customWeekFields.weekOfWeekBasedYear());

    System.out.format(Locale.ENGLISH, "Week begins on %-8s Date is %s. Week %2d or %2d, agree? %s%n", 
            firstDayOfWeek, date.format(dateFormatter), 
            askersCommentWeekNumber, customWeekNumber, 
            askersCommentWeekNumber == customWeekNumber);
}