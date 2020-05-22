final class UniqueValueProvider {
  private int nextId;

  int nextId() {
    return nextId++;
  }
}