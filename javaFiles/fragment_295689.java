List<Map<String, String>> listOfMaps(List<String> list) {
    return list.stream()
               .map(s -> s.split("_", 2))
               .map(a -> Map.of(a[0], a[1]))
               .collect(toList());
}