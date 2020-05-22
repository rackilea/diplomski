public static class ServiceDeserializer extends StdDeserializer<Service> {

    public ServiceDeserializer() {
        super(Service.class);
    }

    @Override
    public Service deserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        List<Utility> objects = Util.getUtilities();
        JsonNode node = jp.getCodec().readTree(jp);
        String id = node.get("id").asText();
        String title = node.get("title").asText();
        String description = node.get("description").asText();
        Service service = new Service(id, title, description);
        for (JsonNode utility : node.get("provides")) {
            String checkId = utility.get("id").asText();
            for (DataObject object : objects) {
                if (object.getId().equals(checkId)) {
                    service.addUtility(object);
                    break;
                }
            }
        }
        return service;
    }
}