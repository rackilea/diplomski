class AFactory {
  private int nextId;

  A createA() {
    return new A(nextId++);
  }
}