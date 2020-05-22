public <T> Set<T> getAllPeople(Class<T> cls) {
    Set<T> itemsOfClass = getAllPeople().stream()
              .filter(cls::isInstance)
              .map(cls::cast)
              .collect(Collectors.toSet());
    return itemsOfClass;
}