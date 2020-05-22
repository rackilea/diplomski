private Object saveValues(String name) {
    if (dataStore.isEssentialField(name)) {
        return valuesMap.computeIfAbsent(name, this::calculateValue);
    }
    return valuesMap.get(name);
}