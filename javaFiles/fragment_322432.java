public class TypedMemberDTODeserializer extends JsonDeserializer<TypedMemberDTO<?>> {

    @Override
    public TypedMemberDTO<?> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        try {
            JsonNode rootNode = jp.getCodec().readTree(jp);
            String type = rootNode.get("type").asText();
            JavaType parametricListType = ctxt.getTypeFactory().constructParametricType(
                    List.class, Class.forName(type));
            JsonNode detailsNode = rootNode.get("details");
            List<?> detailsList = new ObjectMapper().readValue(detailsNode.toString(), parametricListType);
            return new TypedMemberDTO(detailsList, type); // unchecked
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }

    }
}