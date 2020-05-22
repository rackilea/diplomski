LocalDate date = LocalDate.of(1998, Month.JANUARY, 1);
    DateTimeFormatter baseFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");

    DateTimeFormatter chinaFormatter = baseFormatter.withLocale(Locale.CHINA);
    System.out.println("China:   " + date.format(chinaFormatter));

    DateTimeFormatter franceFormatter = baseFormatter.withLocale(Locale.FRANCE);
    System.out.println("France:  " + date.format(franceFormatter));

    DateTimeFormatter irelandFormatter = baseFormatter.withLocale(Locale.forLanguageTag("en-IE"));
    System.out.println("Ireland: " + date.format(irelandFormatter));