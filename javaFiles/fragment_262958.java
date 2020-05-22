List<List<String>> maxValues = new ArrayList<>(
    data.stream()
        .collect(Collectors.groupingBy(
            l -> l.get(0),
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(l -> Integer.parseInt(l.get(1)))), 
                Optional::get
            )
        ))
        .values()
);