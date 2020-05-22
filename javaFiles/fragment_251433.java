public static <T> Set<T> setWith(Set<T> old, T item) {
  return new ImmutableSet.Builder<T>().addAll(old).add(item).build();
}

// ...
Set<Integer> newSet = setWith(oldSet, 3);