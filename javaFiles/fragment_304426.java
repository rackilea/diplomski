public class ShapeDeserializer implements JsonDeserializer<Shape> {

    @Override
    public Shape deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        ShapeType type = context.deserialize(jsonObject.get("type"), ShapeType.class);
        switch (type) {
            case Polygon:
                return context.deserialize(json, PolygonShape.class);
            case MultiPolygon:
                return context.deserialize(json, MultiPolygonShape.class);
            default:
                throw new JsonParseException("Unrecognized shape type: " + type);
        }
    }
}