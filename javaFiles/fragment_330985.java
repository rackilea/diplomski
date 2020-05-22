DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d", Locale.ENGLISH);

    String stringFromFirestore = "2018-05-22T10:30:00+00:00";

    ZonedDateTime dateTime = OffsetDateTime.parse(stringFromFirestore)
            .atZoneSameInstant(ZoneId.systemDefault());
    System.out.println("hour: " + dateTime.toLocalTime());
    System.out.println("date: " + dateTime.format(dateFormatter));