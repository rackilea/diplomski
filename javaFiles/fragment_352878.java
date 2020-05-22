public class RelatedDeserializer extends JsonDeserializer<MagazineRelatedDTO> {

    @Override
    public MagazineRelatedDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            MagazineRelatedDTO value = p.readValueAs(new TypeReference<MagazineRelatedDTO>() {});
            return value;
        } catch (Exception e) {
            return new MagazineRelatedDTO();
        }
    }
}