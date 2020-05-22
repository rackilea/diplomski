public void sort(Comparator<? super E> c) {
  final int expectedModCount = modCount;
  Arrays.sort((E[]) elementData, 0, size, c);
  if (modCount != expectedModCount) {
    throw new ConcurrentModificationException();
  }
  modCount++;
}