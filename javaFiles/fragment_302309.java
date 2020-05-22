private BiFunction<Map<String, String>, String, String> findName = (m, s) -> 
    m.entrySet().stream()
            .filter(entry -> entry.getValue() != null && !entry.getValue().isEmpty() && entry.getValue().equals(s))
            .findFirst()
            .map(Map.Entry::getKey)
            .orElse(null);