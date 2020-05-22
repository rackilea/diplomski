@SuppressWarnings("unchecked")
private static <T>
List<? extends T> unpackResultList(Query query, Class<T> resultType) {
  List<T> results = query.getResultList();
  // A quick and dirty sanity check of just the first value.
  assert results.isEmpty() || resultType.isInstance(results.get(0));
  return results;
}