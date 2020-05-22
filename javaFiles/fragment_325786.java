Set<String> matches = currentObjectPropertiesMap
    .entrySet()
    .stream()
    .filter(e -> Boolean.TRUE.equals(e.getValue()))
    .map(Map.Entry::getKey)
    .filter(k -> Boolean.FALSE.equals(
        updatedObjectPropertiesMap.get(k)
    ))
    .collect(Collectors.toSet());

if(!matches.isEmpty()) throw ...