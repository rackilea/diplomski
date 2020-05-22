public class DoubleDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        String doubleValue = jsonParser.readValueAs(String.class);

        try {
            return Double.valueOf(doubleValue);
        } catch (NumberFormatException ne) {
            System.out.println("Default value is set as the value in json is not compatible with double value");
            return new Double(0);           
        }

    }
}