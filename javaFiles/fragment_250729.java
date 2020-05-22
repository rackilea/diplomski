Map<Integer, Map<String, Map<LocalDate, Long>>>  countDistinctDatesPerMonthPerClient(List<DbRow> input) {
    return input.stream()
            .collect(Collectors.groupingBy(DbRow::getClientNumber,
                    Collectors.groupingBy(DbRow::getTakeoverMonth,
                            Collectors.groupingBy(DbRow::getContractDate, Collectors.counting()))));
}