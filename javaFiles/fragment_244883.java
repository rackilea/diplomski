int sum = inputMap
    .entrySet()
    .stream()
    .filter(entry -> entry.getKey().field().equals(fieldName))
    .mapToInt(entry -> Math.min(entry.getValue().size(), 5))
    .sum();