parents.stream()
        .flatMap(parent -> parent.getChildren()
                            .stream()
                            .map(child -> new SimpleEntry<>(parent, child)))
        .map(pair -> new Parent(pair.getKey().getName(), 
                                Arrays.asList(pair.getValue())))
        .collect(Collectors.toList());