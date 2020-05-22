// parse, try to create a LocalDateTime - if it's not possible, try a LocalDate
TemporalAccessor parsed = fmt.parseBest("10/20/2018", LocalDateTime::from, LocalDate::from);
LocalDateTime dt = null;
if (parsed instanceof LocalDateTime) {
    // LocalDateTime parsed (all fields set)
    dt = (LocalDateTime) parsed;
} else if (parsed instanceof LocalDate) {
    // LocalDate parsed (set time fields)
    dt = ((LocalDate) parsed)
        // set time (use whatever value you want - I'm using 10 AM as example)
        .atTime(LocalTime.of(10, 0));
}