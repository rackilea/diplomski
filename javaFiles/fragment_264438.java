public class FakeString {
  private final String value;

  public FakeString(String value) {
    if (value == null) {
      throw new IllegalArgumentException();
    }
    this.value = value;
  }

  public int hashCode() {
    return value.hashCode();
  }

  public boolean equals(Object o) {
    return value.equals(o);
  }
}