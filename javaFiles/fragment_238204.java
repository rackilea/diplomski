private Object saveValues(String name) {
    Object storedValue = valuesMap.get(name);
    if (dataStore.isEssentialField(name)) {
        if (storedValue != null) {
            return storedValue;
        }
        storedValue = calculateValue(name);
        valuesMap.put(name, storedValue);
    }
    return storedValue;
}