/**
 * Creates {@link ListMultimap} preserving insertion order of keys and values 
 * (it's backed by {@link LinkedHashMap} and {@link ArrayList}).
 */
public static <K, V> ListMultimap<K, V> newLinkedArrayListMultimap() {
  return Multimaps.newListMultimap(
      Maps.<K, Collection<V>>newLinkedHashMap(),
      new Supplier<List<V>>() {
          @Override
          public List<V> get() {
            return Lists.newArrayList();
          }
      });
}