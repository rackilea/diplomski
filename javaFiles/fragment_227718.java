public class InfinityTextFormatter implements TextFormatter {
  @Override
  public String format(float value) {
    // Replace your MAX here
    return (value == MAX) ? "~" : Float.toString(value);
  }
}