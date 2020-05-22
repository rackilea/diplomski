private static <T, R> Matcher<T, R> matchWith(T match) {
    return functions ->  Stream.of(functions)
            .filter(entry -> entry.getKey().equals(match))
            .findFirst()
            .map(Entry::getValue)
            .orElse(null);
}