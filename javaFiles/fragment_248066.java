Map<String, Integer> map2 = Stream.concat(
        score1.entrySet().stream(),
        addition.entrySet().stream()
).collect(Collectors.toMap(
        Entry::getKey, 
        Entry::getValue, 
        (v1, v2) -> v1+ v1)
);