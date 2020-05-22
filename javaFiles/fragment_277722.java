Set<String> allKeys = new HashSet<String>();
for (Map<String,Number> map : allHashMaps) {
  allKeys.addAll(map.keySet());
}
for (Map<String,Number> map : allHashMaps) {
  for (String key : allKeys) {
    if (!map.containsKey(key)) {
      map.put(key, 0);
    }
  }
}