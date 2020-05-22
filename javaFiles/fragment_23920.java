YearMonth endMonth = YearMonth.of(2017, Month.OCTOBER);
    YearMonth startMonth = YearMonth.of(2017, Month.SEPTEMBER);
    for (YearMonth m = endMonth; ! m.isBefore(startMonth); m = m.minusMonths(1)) {
        LocalDateTime monthStart = m.atDay(1).atStartOfDay();
        LocalDateTime monthEnd = m.plusMonths(1).atDay(1).atStartOfDay();

        System.out.println("Month from " + monthStart + " inclusive to " + monthEnd + " exclusive");
    }