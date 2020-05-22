public static void main(String[] args) {
    DateTimeFormatter formatter = 
            new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd[ HH:mm:ss]")
                                          .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                                          .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                                          .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                                          .toFormatter();

    LocalDateTime dt1 = LocalDateTime.parse("2016-01-11", formatter);
    LocalDateTime dt2 = LocalDateTime.parse("2016-01-11 20:10:10", formatter);
}