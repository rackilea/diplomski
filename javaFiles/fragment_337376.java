inputMap.values().stream()
    .flatMap(map -> map.entrySet().stream())

    .flatMap(firstEntry -> firstEntry.getValue()
                           .entrySet().stream()
                           .map(secondEntry -> new SimpleImmutableEntry(
                                                       firstEntry.getKey(),
                                                       secondEntry)
                           )
    )
    .collect(Collectors.groupingBy(
        Entry::getKey,
        Collectors.groupingBy(
          compositeEntry -> compositeEntry.getValue().getKey(),
          Collectors.summingInt(compositeEntry -> compositeEntry.getValue().getValue())
        )
    ));