class Fruits{
  static final Fruits BANANA = new Fruits("BANANA", 0);
  static final Fruits ORANGE = new Fruits("ORANGE", 1);
  static final Fruits APPLE = new Fruits("APPLE", 2);

  private Fruits(String name, int ordinal) {
    super(name, ordinal);
  }
}