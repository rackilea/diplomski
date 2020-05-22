class InventoryItemDeserializer implements JsonDeserializer<InventoryItem> {
    @Override
    public InventoryItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObject = json.getAsJsonObject();
        Category c1 = new Category(jObject.get("cat1_id").getAsInt(), jObject.get("cat1_name").getAsString());
        Category c2 = new Category(jObject.get("cat2_id").getAsInt(), jObject.get("cat2_name").getAsString());
        return new InventoryItem(c1, c2);
    }
}