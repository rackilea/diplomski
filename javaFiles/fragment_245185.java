public static void main(String[] args) {
    String formatter = "yyyy-MM-dd";
    String zone = "Europe/London";
    String date = ZonedDateTime.now(ZoneId.of(zone))
            .format(DateTimeFormatter.ofPattern(formatter));
    System.out.println("date: " + date);
    // create a LocalDate first
    LocalDate localDate = LocalDate.parse(date);
    // then use that and the start of that day (00:00:00) in order to parse a ZonedDateTime
    ZonedDateTime dateTime = localDate.atStartOfDay(ZoneId.systemDefault()); 

    String after = dateTime.plusDays(1).format(DateTimeFormatter.ofPattern(formatter));
    System.out.println("after: " + after);
}