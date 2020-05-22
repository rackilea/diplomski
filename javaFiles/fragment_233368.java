Optional.ofNullable(map)
    .map(m -> m.getOrDefault("model", "")) // Use an empty String if not present
    .filter(s -> !s.isEmpty())             // Filter all empty values
    .ifPresent(valueString -> {            // Check if value is present
        // Logic here
});