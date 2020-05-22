Set<E> set = new LinkedHashSet<E>();
for (E e : input) {
  if (!set.add(e)) {
    throw new IllegalArgumentException();
  }
}
return ImmutableSet.copyOf(set);