private static <T, R> R matchWith(T match, Entry<T, R>...enries) {
    return Stream.of(enries)
            .filter(entry -> entry.getKey().equals(match))
            .findFirst()
            .map(Entry::getValue)
            .orElse(null);
}