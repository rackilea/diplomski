class Overrider extends CollectionConverter {
  @Override
  List toList(Collection c) {...}
  @Override
  <T> List<T> toList(Collection<T> c) {...}
}