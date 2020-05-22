private static <K, V> ListMultimap<K, V> makeLinkedArrayListMultimap() {
  return Multimaps.newListMultimap(Maps.<K, Collection<V>>newLinkedHashMap(), 
      new Supplier<List<V>>() {
        @Override public List<V> get() {
          return Lists.newArrayList();
        }
      });
}

public static void main(final String[] args) {
  final ListMultimap<String, String> multimap = makeLinkedArrayListMultimap();
  multimap.putAll("one", ImmutableList.of("zero", "three"));
  multimap.putAll("two", ImmutableList.of("three", "four", "three"));
  multimap.putAll("three", ImmutableList.<String>of()); // note that this doesn't add key to multimap
  multimap.put("four", "forty-two");

  System.out.println(multimap);
  // prints {one=[one, three], two=[three, four, three], four=[forty-two]}

  final List<String> listForOnes = multimap.get("one");
  System.out.println(listForOnes.get(0));
  // prints zero
}