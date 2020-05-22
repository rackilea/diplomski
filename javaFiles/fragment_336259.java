Map<String, List<String>> multimap = attributes.stream()
        .map(attribute -> new AbstractMap.SimpleEntry<>(attribute, getAttributePrefixes(attribute)))
        .flatMap(entry -> entry.getValue()
            .stream()
            .map(prefix -> new AbstractMap.SimpleEntry<>(prefix, entry.getKey())))
        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));