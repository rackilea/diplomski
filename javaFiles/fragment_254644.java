enum Priority {
  HIGH(1), LOW(3), MEDIUM(2);
  private int value;
  Priority (int value) {
    this.value = value;
  }
  public int getValue() {
    return value;
  }
}