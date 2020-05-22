int max = list.stream()
             .map(map->map.get("A"))
             .filter(Objects::nonNull)
             .mapToInt(Integer::intValue)
             .max()
             .orElse(someDefaultValue);