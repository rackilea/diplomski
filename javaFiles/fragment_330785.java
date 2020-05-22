class Bar {
  static final Bar A = new Bar("A");
  static final Bar B = new Bar("B");

  static final Bar[] $VALUES;

  static {
    Bar[] array = new Bar[2];
    array[0] = A;
    array[1] = B;
    $VALUES = array;
  }

  private Bar(String name) {}
}