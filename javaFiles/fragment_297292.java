source.entrySet()
      .stream()
      .flatMap(e -> e.getValue()
                     .stream()
                     .map(x -> new SimpleEntry<>(x.getMyKey(), e.getKey())))
      .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));