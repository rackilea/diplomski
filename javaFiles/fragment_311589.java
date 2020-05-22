Iterator<Integer> iterator = l.iterator();
while (iterator.hasNext()) {
  int i = iterator.next();
  // ...
  iterator.remove();
}