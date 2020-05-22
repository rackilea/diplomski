public class PojoSerializer extends JsonSerializer<Pojo> {

    @Override
    public void serialize(Pojo pojo, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        /* your pojo */
        jgen.writeStartObject();
        jgen.writeNumberField("st", pojo.getStateTag());
        jgen.writeNumberField("cs", pojo.getContentSize());

        /* inner object */
        jgen.writeStartObject();
        jgen.writeStringField("ty", pojo.getContent().getType());
        jgen.writeStringField("val", pojo.getContent().getValue());
        jgen.writeEndObject();

        jgen.writeEndObject();
    }

    @Override
    public Class<Pojo> handledType() {
        return Pojo.class;
    }

}



ObjectMapper om = new ObjectMapper();

Pojo myPojo = new Pojo(1, 10, new Content("string", "sid"));

SimpleModule sm = new SimpleModule();
sm.addSerializer(new PojoSerializer());
System.out.print(om.registerModule(sm).writerWithDefaultPrettyPrinter().writeValueAsString(myPojo));