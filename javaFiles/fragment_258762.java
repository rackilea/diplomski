int days = daysBetween(
    datePicker1.getvalue(),
    datePicker2.getvalue(),
    Arrays.asList(DayOfWeek.SUNDAY)
);

public static int daysBetween(LocalDate start, LocalDate end, List<DayOfWeek> ignore) {
    int count = 0;
    LocalDate curr = start.plusDays(0); // Create copy.
    while (curr.isBefore(end)) {
        if (!ignore.contains(curr.getDayOfWeek()))
            count++;
        curr = curr.plusDays(1); // Increment by a day.
    }
    return count;
}