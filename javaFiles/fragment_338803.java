Map<String, Integer> output =
    input.entrySet()
         .stream()
         .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), Integer.valueOf(e.getValue())))
         .filter(e -> e.getValue() % 2 == 0)
         .collect(Collectors.toMap(
             Map.Entry::getKey,
             Map.Entry::getValue
         ));