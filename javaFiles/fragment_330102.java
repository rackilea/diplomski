Locale loc = Locale.forLanguageTag("en-NZ");
    DateTimeFormatter dateFormatter
            = DateTimeFormatter.ofPattern("d/M/[yyyy][yy]", loc);

    System.out.println(LocalDate.parse("20/5/2016", dateFormatter));
    System.out.println(LocalDate.parse("20/5/16", dateFormatter));