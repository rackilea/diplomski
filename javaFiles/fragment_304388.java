List<List<String>> data = /* data */ ;

List<List<String> result =
    data.stream()
        .map(l -> l.subList(0, 2))
        .distinct()
        .collect(Collectors.toList());