TreeMap<Type, List<Item>> map = list
    .stream()
    .collect(Collectors.groupingBy(
        Item::Type,
        () -> new TreeMap<>(Comparator.comparingLong(Type::getId)), 
        Collectors.toList()));