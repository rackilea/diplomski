excludeNumbers(mainList.stream()
        .map(m -> m.get("Number"))
        .collect(Collectors.toList()), date);
    excludeTypes( mainList.stream()
        .map(m -> m.get("Type"))
        .collect(Collectors.toList()), date);