<T> List<T> commonElements(Iterable<? extends List<? extends T>> lists) {
  Iterator<? extends List<? extends T>> it = lists.iterator();
  List<T> commonElements = new ArrayList<T>(it.next());
  while (it.hasNext()) {
    commonElements.retainAll(it.next());
  }
  return commonElements;
}