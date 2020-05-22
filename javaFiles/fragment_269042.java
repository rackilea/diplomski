class Foo<T> {
  private final Class<T> clazz;

  Foo (final Class<T> clazz) { // require creator to supply a Class<T>
    this.clazz = clazz;
    if (clazz == null) {
      throw new NullPointerException();
    }
  }

  void bar () { 
    if (Serializable.class.isAssignableFrom(clazz)) {
      ...
    }
  } 
}