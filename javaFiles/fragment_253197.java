@SuppressWarnings("unchecked")
static <T> Stream<T> mapTraversalStream(Map<Integer, T> map) {
  return map.values().stream().flatMap(value -> {
    if(value instanceof Map) {
      return mapTraversalStream((Map<Integer, T>)value);
    } else {
      return Stream.of(value);
    }
  });
}

static <T> Iterator<T> mapTraversalIterator(Map<Integer, T> map) {
  return mapTraversalStream(map).iterator();
}