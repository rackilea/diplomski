Properties props = System.getProperties();
Map<String, String> systemMap = includes.stream()
    .filter(props::containsKey)
    .sorted()
    .collect(Collectors.toMap(s -> s, props::getProperty,
        (e1, e2) -> e2, 
        LinkedHashMap::new)
    );