Map<String, List<Element>> collected = elMap.entrySet()
        .stream()
        .peek(entry -> System.out.println("Performing arbitrary Map operations"))
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
            return entry.getValue()
                    .stream()
                    .sorted(Comparator.comparingDouble(Element::getWeight))
                    .collect(Collectors.toList());
        }));

collected.entrySet()
        .forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });