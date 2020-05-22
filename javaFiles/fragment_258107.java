static List<MonthInterval> list(LocalDateTime begin, LocalDateTime end) {
    List<MonthInterval> list = new ArrayList<>();
    LocalDateTime nextDayMonth;
    do {
        nextDayMonth = begin.plusMonths(1).withDayOfMonth(1);
        list.add(new MonthInterval(begin, nextDayMonth));
        begin = nextDayMonth;
    } while (nextDayMonth.getMonthValue() != end.getMonthValue());
    list.add(new MonthInterval(begin, end));
    return list;
}