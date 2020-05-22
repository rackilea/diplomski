Set<Map<Integer, String>> combinations(List<Integer> keys, List<String> values) {
    if (keys.isEmpty())
        return Collections.singleton(new HashMap<>());
    else
        return keys.stream().flatMap(k -> 
            values.stream().flatMap(v -> 
                combinations(listWithout(keys, k), listWithout(values, v)).stream()
                    .peek(c -> c.put(k, v)))).collect(toSet());
}

private <T> List<T> listWithout (List<T> input, T value) {
    return input.stream().filter(v -> !v.equals(value)).collect(toList());
}