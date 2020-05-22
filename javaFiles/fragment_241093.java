final List<Map<String, Object>> l1 = ...;
final List<Map<String, Object>> l2 = ...;

final List<Map<String, Object>> result = l1.stream()
    .map(map ->
    {
      final Map<String, Object> r = new HashMap<>(map);
      l2.stream()
          .filter(map2 -> Objects.equals(map.get("ACC_NUM"), map2.get("ACC_NUM")))
          .findFirst()
          .map(map2 -> map2.get("IS_ACTIVE"))
          .ifPresent(is_active -> map.put("IS_ACTIVE", is_active));
      return r;
    })
    .collect(Collectors.toList());