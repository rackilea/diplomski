public static List<String[]> aggregate(List<String[]> data) {
    List<String[]> aggregated = data.stream()
            .skip(1)
            .map(Arrays::asList)
            .collect(Collectors.groupingBy(
                    a -> a.subList(0, 5),
                    () -> new TreeMap<>(
                            Ordering.from(String.CASE_INSENSITIVE_ORDER)
                                    .lexicographical()),
                    Collectors.mapping(
                            a -> String.join(",", a.subList(5, 8)),
                            Collectors.joining("; "))))
            .entrySet()
            .stream()
            .map(e -> Stream.concat(
                    e.getKey().stream(),
                    Stream.of(e.getValue())))
            .map(s -> s.toArray(String[]::new))
            .collect(Collectors.toCollection(ArrayList::new));

    aggregated.add(0, new String[] {"name","sname","Id1","Id2","type","Comment"});

    return aggregated;
}