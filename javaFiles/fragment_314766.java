public class NonNegative {
  private final double n;

  private NonNegative(double n) {
    Preconditions.checkArgument(n >= 0.0);
    this.n = n;
  }

  @JsonValue
  public double getValue() {
    return n;
  }
}