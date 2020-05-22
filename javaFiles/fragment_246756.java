public Interval getPeriod() {
    DateTime d = new DateTime(); // current date
    DateTime start = d.withDayOfMonth(1).minusMonths(12) // day 1 of 12 months ago
                      .withTimeAtStartOfDay(); // start date
    DateTime end = d.minusMonths(1) // previous month
                    .dayOfMonth().withMaximumValue() // last day of month
                    .withTime(23, 59, 59, 999); // end date

    return new Interval(start, end);
}