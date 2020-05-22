public static class EntrySerializer implements JsonSerializer<Entry<String, String>> {
    @Override
    public JsonElement serialize(Entry<String, String> entry, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement serializedKey = context.serialize(entry.getKey());
        JsonElement serializedValue = context.serialize(entry.getValue());

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("key", serializedKey);
        jsonObject.add("value", serializedValue);
        return jsonObject;
    }
}