Map.Builder<String,String> resultMap = ImmutableMap.builder(..)

listOfItems.stream()
        .filter(Objects::nonNull)
        .distinct()
        .forEach(item -> getProcessedItem(item,anotherParam)
                         .ifPresent(result -> resultMap.put(item result));
    return resultMap.build();