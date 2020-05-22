Map<String, Map<String, Long>> organizationApps = input.stream()
    .flatMap(e -> e.entrySet().stream())
    .collect(groupingBy(Map.Entry::getKey, Collector.of(HashMap::new,
        (r, t) -> t.getValue().forEach((k, v) -> r.merge(k, v, Long::sum)),
        (r1, r2) -> {
            r2.forEach((v1, v2) -> r1.merge(v1, v2, Long::sum));
            return r1;
        },
        (Map<String, Long> m) -> m.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new))
    )));