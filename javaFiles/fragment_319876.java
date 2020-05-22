Set<Object> seen = ConcurrentHashMap.newKeySet();

    Map<String, List<Item>> m = 
       l.stream()
        .filter(item -> seen.add(item.category + ":" + item.name + ":" + item.code))
        .collect(Collectors.groupingBy(item -> item.category,
            Collectors.mapping(item -> new Item(item.code, item.name), 
                               Collectors.toList())));