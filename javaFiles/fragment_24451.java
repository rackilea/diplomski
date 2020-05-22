Map<String, Integer> counts = Stream.of(data).flatMap(Stream::of)
    .collect(Collectors.toMap(Function.identity(), v->1, (x, y)->x+y));

List<String> overThreshold = counts.entrySet().stream()
    .filter(v->v.getValue() >= 10)
    .map(Map.Entry::getKey).collect(Collectors.toList());