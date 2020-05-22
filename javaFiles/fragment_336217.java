public <E> boolean fasterListContains(List<E> a, List<E> b) {
  Set<E> aSet = new HashSet<>();
  aSet.addAll(a);
  for (E element : b) {
    if (aSet.contains(b)) {
      return true;
    }
  }
  return false;
}