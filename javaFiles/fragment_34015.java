public class ResourceDeserializer implements JsonDeserializer<Resource> {

    @Override
    public Resource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject root = json.getAsJsonObject();

        final Resource resource;

        if("wood".equalsIgnoreCase(root.get("type"))) {
            resource = new WoodResource();
        } else {
            resource = new StoneResource();
        }

        return resource;
    }

}