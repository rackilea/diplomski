public static Map<LocalDate, Integer> cumulativeWeeklySum(SortedMap<LocalDate, Integer> data) {
    AtomicInteger cumulativeSum = new AtomicInteger(0);
    return data.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, e -> cumulativeSum.addAndGet(e.getValue())))
        .entrySet().stream()
        .filter(e -> e.getKey().getDayOfWeek() == DayOfWeek.MONDAY || e.getKey().equals(data.lastKey()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}