DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("h:mm a")
            .toFormatter(Locale.ENGLISH);
    LocalTime start = LocalTime.parse("11:00 am", formatter);
    LocalTime end = LocalTime.parse("1:00 pm", formatter);
    LocalTime current = LocalTime.parse("12:00 pm", formatter);

    boolean reserved = false;
    if (current.isAfter(start) && current.isBefore(end)) {
        reserved = true;
    }