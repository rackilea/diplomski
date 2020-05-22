Map<String, Thing[]> result = source.stream()
                .collect(groupingBy(Thing::getOwnerId))
                .entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey,
                        e -> e.getValue().toArray(new Thing[0])));