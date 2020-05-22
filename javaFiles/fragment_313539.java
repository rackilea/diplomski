DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, uuuu", Locale.ENGLISH);
    String selectedDate = "Jan 18, 2020";
    ZonedDateTime zdt = LocalDate.parse(selectedDate, dateFormatter)
            .atStartOfDay(ZoneOffset.UTC);
    System.out.println(zdt);
    long millisSinceEpoch = zdt.toInstant().toEpochMilli();
    System.out.println(millisSinceEpoch);