int getFirstCorrectValueBiggerThan (int lastValue) {
    return groupMap.entrySet().stream()
            .filter(entry -> Objects.equals(entry.getValue(), 1))
            .map(Map.Entry::getKey)
            .filter(value -> value > lastValue)
            .findFirst();
}