public static <T extends Object & Comparable<? super T>> T max(
  Collection<? extends T> collection) {
  Iterator<? extends T> it = collection.iterator();
  T max = it.next();
  while (it.hasNext()) {
    T next = it.next();
    if (max.compareTo(next) < 0) {
      max = next;
    }
  }
  return max;
}