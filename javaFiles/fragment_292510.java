String dateTimeString = "2018-05-15 09:32:51.550082 +3:00";
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("uuuu-MM-dd HH:mm:ss.SSSSSS ")
            .appendOffset("+H:MM:ss", "+0:00")
            .toFormatter();
    OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString, formatter);
    System.out.println(dateTime);