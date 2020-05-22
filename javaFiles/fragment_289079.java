class ShapeDeserializer implements JsonDeserializer<Shape> {
    @Override
    public Shape deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map.Entry<String, JsonElement> entry = json.getAsJsonObject().entrySet().iterator().next();
        switch(entry.getKey()) {
            case "circle":
                return context.deserialize(entry.getValue(), Circle.class);
            case "square":
                return context.deserialize(entry.getValue(), Square.class);
            default:
                throw new IllegalArgumentException("Can't deserialize " + entry.getKey());
        }
    }
}