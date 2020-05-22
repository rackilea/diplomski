DateTimeFormatter formatter
            = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                    .withLocale(Locale.US);

    String startDate = "2019-02-18T06:30:38.9933333"; // Input String
    LocalDateTime dateTime = LocalDateTime.parse(startDate);
    System.out.println(dateTime.format(formatter));