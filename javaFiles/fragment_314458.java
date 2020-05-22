public static class RoleSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(((Role) value).getRole());
    }
}

public static class RoleDeserializer extends JsonDeserializer {
    @Override
    public Role deserialize(JsonParser jsonParser,DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        Role role =  new Role();
        role.setRole(node.asText());
        return role;
    }
}