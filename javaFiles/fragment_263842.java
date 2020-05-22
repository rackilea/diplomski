LocalDate today = LocalDate.now(ZoneId.of("Europe/Belgrade"));
    LocalDate firstDayOfCurrentMonth = today.withDayOfMonth(1);
    LocalDate lastDayOfCurrentMonth = today.with(TemporalAdjusters.lastDayOfMonth());
    YearMonth lastMonth = YearMonth.of(today.getYear(), today.getMonth())
                            .minusMonths(1);
    LocalDate firstDayOfLastMonth = lastMonth.atDay(1);
    LocalDate lastDayOfLastMonth = lastMonth.atEndOfMonth();