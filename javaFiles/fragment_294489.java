DateTimeFormatter dateTimeFormatter = 
    DateTimeFormatter
    .ofPattern("dd MMMM uuuu")
    .withLocale( new Locale("ru") )
;
LocalDate ld = LocalDate.parse(rDate, dateTimeFormatter);