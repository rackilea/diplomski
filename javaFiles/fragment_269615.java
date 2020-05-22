Collection<KeywordMerged> result = keywords.stream()
    .collect(Collectors.toMap(
        Keyword::getId,
        k -> KeywordMerged.from(k), // you can replace this lambda with a method reference
        (left, right) -> {
            left.getMetricList().addAll(right.getMetricList());
            return left;
        }))
    .values();