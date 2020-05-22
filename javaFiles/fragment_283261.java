LocalDate date = LocalDate.now().withDayOfMonth(1);
    LocalDate end = date.plusMonths(1);

    List<LocalDate> dates = new ArrayList<>();
    while(date.isBefore(end)) {
        dates.add(date);
        date = date.plusDays(1);
    }