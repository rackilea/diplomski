public class ArrayToMapDeserializer extends JsonDeserializer<SortedMap<Object, Object>>
    implements ContextualDeserializer {

    private Class<?> keyAs;

    private Class<?> contentAs;

    @Override
    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        return this.deserialize(p, ctxt, new HashMap<>());
    }

    @Override
    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt,
        Map<Object, Object> intoValue) throws IOException, JsonProcessingException {
        JsonNode node = p.readValueAsTree();
        ObjectCodec codec = p.getCodec();
        if (node.isArray()) {
            node.forEach(entry -> {
                try {
                    JsonNode keyNode = entry.get(0);
                    JsonNode valueNode = entry.get(1);
                    intoValue.put(keyNode.traverse(codec).readValueAs(this.keyAs),
                        valueNode.traverse(codec).readValueAs(this.contentAs));
                } catch (NullPointerException | IOException e) {
                    // skip entry
                }
            });
        }
        return intoValue;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
        throws JsonMappingException {
        JsonDeserialize jsonDeserialize = property.getAnnotation(JsonDeserialize.class);
        this.keyAs = jsonDeserialize.keyAs();
        this.contentAs = jsonDeserialize.contentAs();
        return this;
    }

}