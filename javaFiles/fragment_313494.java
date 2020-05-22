final String json = "[{\"type\":\"string\",\"value\":\"value1\",\"field\":\"label\"},{\"type\":\"string\",\"value\":\"value2\",\"field\":\"address_unique\"}]";
final JsonParser parser = new JsonParser();
final JsonElement rootElement = parser.parse(json);
final JsonArray values = rootElement.getAsJsonArray();
for (final JsonElement value : values) {
    final JsonObject obj = value.getAsJsonObject();
    final Filter filter = new Filter();
    filter.setType(obj.get("type"));
    filter.setValue(obj.get("value"));
    filter.setField(obj.get("field"));
}