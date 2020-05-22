final class StringWithUppercaseSize {
  public final String string;
  public final int uppercaseLength;

  public StringWithUppercaseSize(String string, int uppercaseLength) {
    this.string = string;
    this.uppercaseLength = uppercaseLength;
  }

  public int getUppercaseLength() {
    return this.uppercaseLength;
  }
}