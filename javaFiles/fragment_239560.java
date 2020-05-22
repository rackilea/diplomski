import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public DayOfWeek parseFromString(String str, TextStyle style, Locale locale) {
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        // Day of the week field, using the same TextStyle
        .appendText(ChronoField.DAY_OF_WEEK, style)
        // use the same locale
        .toFormatter(locale);
    // parse returns a TemporalAccessor, DayOfWeek::from converts it to a DayOfWeek object
    return formatter.parse(str, DayOfWeek::from);
}