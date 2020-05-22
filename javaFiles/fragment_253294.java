Map<String, Map<String, Long>> organizationApps = input.stream()
    .flatMap(m -> m.entrySet().stream())
    .collect(groupingBy(Map.Entry::getKey, collectingAndThen(flatMapping(
            t -> t.getValue().entrySet().stream(),
            toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum)),
        (Map<String, Long> m) -> m.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new))
    )));