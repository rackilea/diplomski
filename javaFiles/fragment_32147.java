ArrayList<Object> list = ...

result = list.stream()                // Stream<Object>
    .filter(String.class::isInstance) // Stream<Object>
    .map(String.class::cast)          // Stream<String>
    .collect(Collectors.toList());