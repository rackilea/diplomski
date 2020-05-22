List<TestObject> newList = list.stream()
        .filter(x ->
                filterMap.entrySet().stream()
                        .allMatch(y ->
                                x.getProperty(y.getKey()) == y.getValue()
                        )
        )
        .collect(Collectors.toList());