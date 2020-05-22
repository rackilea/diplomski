public class FlatMap {

  public static Stream<Map.Entry<?, ?>> flatten(Map.Entry<?, ?> e) {
    if (e.getValue() instanceof Map<?, ?>) {
      return Stream.concat(Stream.of(new AbstractMap.SimpleEntry<>(e.getKey(), "")),
                           ((Map<?, ?>) e.getValue()).entrySet().stream().flatMap(FlatMap::flatten));
    }

    return Stream.of(e);
  }
}