public class DecimalJsonSerializer extends JsonSerializer<Double> {
  @Override
  public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) 
    throws IOException, JsonProcessingException {
      jgen.writeString( String.format("%.2f", value));
  }
}