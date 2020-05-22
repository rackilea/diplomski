static class Point2DDeserializer implements JsonDeserializer<Point2D>, JsonSerializer<Point2D> {

    @Override
    public Point2D deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        Point2D.Double ans = new Point2D.Double();
        JsonObject obj = json.getAsJsonObject();

        ans.x = obj.get("x").getAsDouble();
        ans.y = obj.get("y").getAsDouble();

        return ans;
    }

    @Override
    public JsonElement serialize(final Point2D point2D, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return new Gson().toJsonTree(point2D);
    }
}