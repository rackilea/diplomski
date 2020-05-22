public class FlexibleFloatDeserializer extends JsonDeserializer<Float> {

    @Override
    public Float deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        String floatString = parser.getText();
        if (floatString.contains(",")) {
            floatString = floatString.replace(",", ".");
        }
        return Float.valueOf(floatString);
    }

}