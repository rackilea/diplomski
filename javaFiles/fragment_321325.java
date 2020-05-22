final class CustomPatterns {

    private CustomPatterns() {
    }

    private static final Map<Long, String> dayOfWeek = ImmutableMap.<Long, String>builder()
            .put(1L, "Mon")
            .put(2L, "Tue")
            .put(3L, "Wed")
            .put(4L, "Thu")
            .put(5L, "Fri")
            .put(6L, "Sat")
            .put(7L, "Sun")
            .build();

    private static final Map<Long, String> monthOfYear = ImmutableMap.<Long, String>builder()
            .put(1L, "Jan")
            .put(2L, "Feb")
            .put(3L, "Mar")
            .put(4L, "Apr")
            .put(5L, "May")
            .put(6L, "Jun")
            .put(7L, "Jul")
            .put(8L, "Aug")
            .put(9L, "Sep")
            .put(10L, "Oct")
            .put(11L, "Nov")
            .put(12L, "Dec")
            .build();

    static final DateTimeFormatter customDateTimeFormatter = new DateTimeFormatterBuilder()
            .appendText(DAY_OF_WEEK, dayOfWeek)
            .appendLiteral(' ')
            .appendText(MONTH_OF_YEAR, monthOfYear)
            .appendLiteral(' ')
            .appendValue(DAY_OF_MONTH, 1, 2, NOT_NEGATIVE)
            .appendLiteral(' ')
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .appendLiteral(' ')
            .appendOffset("+HHMM", "+0000")
            .appendLiteral(' ')
            .appendValue(YEAR)
            .toFormatter();

}