@Override
public Iterator<Test> iterator() {
  return Arrays.asList(this).iterator();
  // or Collections.singleton(this).iterator()
  // or Stream.of(this).iterator()
  // or many other possibilities.
}