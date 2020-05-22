public Map<String, List<Map<String, String>>> doGrouping(
        List<String> columns,
        List<Map<String, String>> data) {

    return data.stream()
        .collect(Collectors.groupingBy(
            elem -> columns.stream()
                .map(elem::get)
                .collect(Collectors.joining())));
}