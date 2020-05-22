unsortedMap.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByKey())
    .collect(Collectors.toMap(
       Map.Entry::getKey,
       Map.Entry::getValue,
       (v1, v2) -> v1, // you will never merge though ask keys are unique.
       LinkedHashMap::new
    ));