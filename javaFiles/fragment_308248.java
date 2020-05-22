WeekFields weekFields = WeekFields.of(Locale.forLanguageTag("mt_MT"));

    int weeksLimit = 5; // this value is passed into the method, but just setting it here as an example

    LocalDate today = LocalDate.now(ZoneId.of("Europe/Malta"));
    Map<Integer, List<Integer>> yearWeeks = IntStream.rangeClosed(1, weeksLimit)
            .mapToObj(i -> today.minusWeeks(i))
            .collect(Collectors.groupingBy(ld -> ld.get(weekFields.weekBasedYear()),
                    Collectors.mapping(ld -> ld.get(weekFields.weekOfWeekBasedYear()),
                            Collectors.toList())));

    System.out.println(yearWeeks);