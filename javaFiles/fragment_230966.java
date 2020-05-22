static Set<Integer> set(int... ints) {
  return new LinkedHashSet<>(Ints.asList(ints));
}

@SafeVarargs
static <T> Set<Set<T>> sets(Set<T>... sets) {
  return new LinkedHashSet<>(Arrays.asList(sets));
}