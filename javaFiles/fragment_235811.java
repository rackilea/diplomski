initialMap.entrySet()
          .stream()
          .flatMap(entry -> entry.getValue().stream().map(v -> new SimpleEntry<>(entry.getKey(), v)))
          .collect(Collectors.groupingBy(
               Entry::getValue,
               Collectors.mapping(Entry::getKey, Collectors.toList())
         ));