DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.DAY_OF_MONTH, 1)
            .appendValue(ChronoField.MONTH_OF_YEAR, 1)
            .appendValue(ChronoField.YEAR, 4)
            .toFormatter();

    String dateOfBirth = "312015";
    LocalDate dateTime = LocalDate.parse(dateOfBirth, dateFormatter);
    System.out.println(dateTime);