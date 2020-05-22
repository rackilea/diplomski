public Fallible(final T value) {
  if (value instanceof Exception) {
    this.exception = (Exception) value;
    this.value = null;
  } else {
    this.value = value;
    this.exception = null;
  }
}