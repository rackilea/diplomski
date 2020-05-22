public class CustomerInfoSerializer extends JsonSerializer<CustomerInfo> {

    @Override
    public void serialize(CustomerInfo c, JsonGenerator jg, SerializerProvider sp) 
            throws IOException, JsonProcessingException {
        jg.writeStartObject();
        jg.writeObjectField(c.getInfoType(), c.getProperties());
        jg.writeEndObject();
    } 
}