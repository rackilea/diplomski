keyToValuesMap.entrySet()
              .stream()
              .flatMap(entry -> entry.getValue()
                                     .stream()
                                     .map(v -> new SimpleEntry(entry.getKey(),v)))
              .forEach(entry -> printEntry(entry));