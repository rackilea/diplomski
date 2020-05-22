class A {
  private B b;

  public void setB(B b) {
    this.b = b;
  }

  public void listenerMethod() {
    if (b != null) {
      b.someBMethod();
    }
  }
}