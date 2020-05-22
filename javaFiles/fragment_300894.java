interface CollectionAdders<E> {
  boolean add(E e);
  boolean addAll(Collection<? extends E> c);
}

interface ListGetters<E> {
  E get(int index);
}

class Foo {
  @Delegate(types={CollectionAdders.class, ListGetters.class})
  List<String> names = new ArrayList<>();
}