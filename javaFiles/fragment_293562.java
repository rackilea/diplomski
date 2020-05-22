final DateTimeFormatter dtf = new DateTimeFormatterBuilder()
        .appendOptional(DateTimeFormatter.ofPattern("EEEE"))
        .appendOptional(DateTimeFormatter.ofPattern("E"))
        .toFormatter(locale);

final DayOfWeek dow1 = DayOfWeek.from(dtf.parse("Mon"));
final DayOfWeek dow2 = DayOfWeek.from(dtf.parse("Monday"));