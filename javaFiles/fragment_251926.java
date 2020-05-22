public static <T> boolean safeContainsKey(Map<T, ?> map, T key) {
  return map.containsKey(key);
}

public static <T, U> U safeGet(Map<T, U> map, T key) {
  return map.get(key);
}