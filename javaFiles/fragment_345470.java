class A {
  final int id;

  A(UniqueValueProvider uvp) {
    this.id = uvp.nextId();
  }
}