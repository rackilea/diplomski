public class HttpStatusDeserializer extends JsonDeserializer<HttpStatus> {    
    @Override
    public HttpStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return HttpStatus.valueOf(Integer.parseInt(node.asText()));
    }
}