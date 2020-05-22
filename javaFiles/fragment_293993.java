Map<Long, String> monthNames = Arrays.stream(Month.values())
            .collect(Collectors.toMap(m -> Long.valueOf(m.getValue()), Month::toString));
    DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
            .appendText(ChronoField.MONTH_OF_YEAR, monthNames)
            .appendPattern(" d, uuuu")
            .toFormatter();
    LocalDate date = LocalDate.of(2018, Month.OCTOBER, 21);
    String formattedDate = date.format(dateFormatter);
    System.out.println(formattedDate);