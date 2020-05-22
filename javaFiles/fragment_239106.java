final LocalDate beginDate = LocalDate.of(2017, Month.JANUARY, 1);
    final LocalDate endDate = LocalDate.of(2020, Month.DECEMBER, 31);
    final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    LocalDate currentDate = beginDate;
    while (currentDate.isBefore(endDate) && ! fulfilsCondition(currentDate)) {
        currentDate = currentDate.plusDays(1);
    }
    if (fulfilsCondition(currentDate)) {
        System.out.println("This date hit the condition: " + currentDate.format(dateFormatter));
    } else {
        System.out.println("No date in the range hit the condition");
    }