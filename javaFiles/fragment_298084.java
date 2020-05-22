Map<String, List<String>> result = anotherHashMap
    .entrySet().stream()                    // Stream over entry set
    .collect(Collectors.toMap(              // Collect final result map
        Map.Entry::getKey,                  // Key mapping is the same
        e -> e.getValue().stream()          // Stream over list
            .sorted(Comparator.comparingLong(MyObject::getPriority)) // Sort by priority
            .map(MyObject::getName)         // Apply mapping to MyObject
            .collect(Collectors.toList()))  // Collect mapping into list
        );