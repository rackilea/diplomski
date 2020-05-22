Map<String, Long> longMap = ...;
Map<String, ?> wildcardMap = longMap;
wildcardMap.put("", "");  // Compiler error!

// but if it did work, the following would be a runtime error:
Long value = longMap.values().iterator().next();