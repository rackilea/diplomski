interface Bar {
  void frob();
}

interface Foo<T extends Bar> {
  void frood(T bar);
}