// no need to copy a List (result of Array.asList) to an ArrayList, by the way
List<Map<String, String>> l = Arrays.asList(m0, m1);

List<Map<String, String>> tx = l.stream().map(m -> m.entrySet().stream()
        .filter(map -> map.getKey().equals("x") || map.getKey().equals("z"))
        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())))
    .collect(Collectors.toList());