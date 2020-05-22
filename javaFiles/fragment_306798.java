public String getFileName(final String baseName, final DateTime dateTime, final Supplier<String> valueLoader) {
    final Optional<String> cached = cache.asMap().entrySet()
            .stream()
            .filter(entry -> entry.getKey().getBaseName().equals(baseName) && entry.getKey().isBetweenInclusive(dateTime))
            .findFirst()
            .map(Map.Entry::getValue);

    if (cached.isPresent()) {
        return cached.get();
    } else {
        final String evaluatedValue = valueLoader.get();
        cache.put(new CachedResult(baseName, intervalCalculator.getInterval(dateTime)), evaluatedValue);
        return evaluatedValue;
    }
}