private static List<String> monthNamesFromQuarter(int quarter) {
    // you can do the validation of quarter yourself
    int start = quarter * 3 - 2;
    return IntStream.range(start, start + 3)
            .mapToObj(Month::of)
            .map(Month::name)
            .collect(Collectors.toList());
}