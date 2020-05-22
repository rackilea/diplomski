public List<Object> populateResultList(List<String> list) {
    return list.stream()
            .map(fieldName -> mappings.getOrDefault(fieldName.toLowerCase(), it -> null).apply(this))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
}