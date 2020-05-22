Map<?, ?> collect = stringObjectMap.entrySet()
                                   .stream()
                                   .flatMap(FlatMap::flatten)
                                   .collect(Collectors.toMap(
                                       Map.Entry::getKey,
                                       Map.Entry::getValue,
                                       (u, v) -> throw new IllegalStateException(String.format("Duplicate key %s", u)),
                                       LinkedHashMap::new));