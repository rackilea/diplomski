public <E> boolean slowListContains(List<E> a, List<E> b) {
  for (E element : a) {
    if (b.contains(element)) {
      return true;
    }
  }
  return false;
}