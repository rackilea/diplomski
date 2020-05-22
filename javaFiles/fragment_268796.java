class CustomSerializer extends JsonSerializer<JsonResponse> {
@Override
public void serialize(JsonResponse value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
    jgen.writeStartObject();
    jgen.writeBooleanField("success", value.isSuccess());

    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.convertValue(value.getResult().getObject(), JsonNode.class);
    JsonNode rootNode = mapper.createObjectNode();
    ((ObjectNode) rootNode).set(value.getResult().getObject().getClass().getSimpleName(), node);
    jgen.writeObjectField("result", rootNode);

    jgen.writeEndObject();
}