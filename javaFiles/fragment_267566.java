public static class BadDoubleDeserializer implements JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        try {
            return Double.parseDouble(element.getAsString().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new JsonParseException(e);
        }
    }

}