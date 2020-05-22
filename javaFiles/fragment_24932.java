public class CustomerInfoDeserializer extends JsonDeserializer<CustomerInfo> {

    private final Set<String> allowedFields;

    public CustomerInfoDeserializer(String... allowedFields) {
        Set<String> allowed = new HashSet<>(Arrays.asList(allowedFields));
        this.allowedFields = Collections.unmodifiableSet(allowed);
    }

    @Override
    public CustomerInfo deserialize(JsonParser jp, DeserializationContext dc) 
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String field = node.fieldNames().next();
        if (!allowedFields.contains(field)) {
            throw new JsonMappingException("Field '" + field + "' not allowed");
        }

        CustomerInfo info = new CustomerInfo();
        info.setInfoType(field);
        JsonNode dataNode = node.get(field);
        for (Iterator<String> it = dataNode.fieldNames(); it.hasNext();) {
            String name = it.next();
            info.addProperty(name, dataNode.get(name).asText());
        }

        return info;
    }  
}