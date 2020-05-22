class Box<T> {
  private T value;
  T get() {
    return value;
  }

  void set(T value) {
    this.value = value;
  }
}