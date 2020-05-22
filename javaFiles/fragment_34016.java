abstract class Resource {
    protected String id;
    protected Integer quantity;
}

class Wood extends Resource {}

class Stone extends Resource {}

class ResourceMap {
    protected Map<String,Resource> resources;

    ResourceMap() {
        this.resources = new HashMap<>();
    }
}

class ResourceMapDeserializer implements JsonDeserializer<ResourceMap> {

    @Override
    public ResourceMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject root = json.getAsJsonObject();

        final ResourceMap instance = new ResourceMap();
        instance.resources.put("Wood", parse(root, "Wood"));
        instance.resources.put("Stone", parse(root, "Stone"));

        return instance;
    }

    private Resource parse(JsonObject root, String fieldName) {
        final JsonElement field = root.get(fieldName);

        if(field != null) {
            final Resource resource;

            if("Wood".equalsIgnoreCase(fieldName)) {
                resource = new Wood();
            } else {
                resource = new Stone();
            }

            resource.quantity = field.getAsJsonObject().get("quantity").getAsInt();

            return resource;

        } else {
            return null;
        }
    }

}