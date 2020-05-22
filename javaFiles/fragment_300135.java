class Base {
  public Base() { } // Existing constructors

  public Base(Base other) {
    this.a = other.a;
    this.b = other.b;
    // ...
  }
}