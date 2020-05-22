public class DoubleDecimalSerializerWithSixDigitPrecisionAndDotSeparator
    extends JsonSerializer<Double> {

  @Override
  public void serialize(Double value, JsonGenerator generator, SerializerProvider serializers)
      throws IOException {
    generator.writeNumber(String.format(Locale.US, "%.6f", value));
  }
}