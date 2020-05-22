List<int> filtered(List<Abc> list1, List<Abc> list2) {
    Set<String> dataStrings = list2.stream()
        .map(x -> x.dataString))
        .collect(Collectors.toSet());

    return list1.stream()
        .filter(x -> dataStrings.contains(x.dataString))
        .map(x -> x.rowNum)
        .collect(Collectors.toList());
}