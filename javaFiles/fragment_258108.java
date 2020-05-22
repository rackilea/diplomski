static List<MonthInterval> list(LocalDateTime begin, LocalDateTime end) {
    List<MonthInterval> list = new ArrayList<>();
    LocalDateTime nextDayMonth;
    for (int i = 0; i < ChronoUnit.MONTHS.between(begin, end) + 1; i++) {
        nextDayMonth = begin.plusMonths(1).withDayOfMonth(1);
        list.add(new MonthInterval(begin, nextDayMonth));
        begin = nextDayMonth;
    }
    list.add(new MonthInterval(begin, end));
    return list;
}