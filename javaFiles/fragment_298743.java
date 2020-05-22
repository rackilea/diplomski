public Map<String, Long> countCodingsByDate() {
    return codingHistory.historyDate.stream()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()
        ));
}