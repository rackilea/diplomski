final Map<MyCoolKey, Optional<MyCoolValue>> myCoolMap = new HashMap<>();

Optional<Map<MyCoolKey, MyCoolValue>> output = Optional.of(myCoolMap)
    .filter(map -> map.values().stream().allMatch(Optional::isPresent))
    .map(map -> map
        .entrySet()
        .stream()
        .collect(toMap(
            Map.Entry::getKey,
            entry -> entry.getValue().get()
        ))
    );