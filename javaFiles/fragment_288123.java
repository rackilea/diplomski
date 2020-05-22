public List<LocalDate> filterDates(List<LocalDate> dates) {
    return dates.stream()
            .collect(Collectors.groupingBy(YearMonth::from))
            .values()
            .stream()
            .map(Collections::min) // .map(Collections::max)
            .collect(Collectors.toList());
}