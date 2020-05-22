private static final Set<Integer> VALID_DAYS = ImmutableSet.of(
    Calendar.SUNDAY, Calendar.MONDAY, Calendar.TUESDAY,
    Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY,
    Calendar.SATURDAY);

public static TimeSlice getPreviousWeek(Date referenceDate, int startDayOfWeek)
{
    if (!VALID_DAYS.contains(startDayOfWeek))
    {
        throw ...
    }
}