Map<Type, List<Item>> str = list1.stream()
    .collect(
        Collectors.groupingBy(
            Item::Type, 
            () -> new TreeMap<>(Comparator.comparingLong(Type::getId)),
            Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream()
                    .sorted(Comparator.comparingLong(Item::getId))
                    .collect(Collectors.toList()))));