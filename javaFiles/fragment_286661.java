SimpleModule simpleModule = new SimpleModule("SimpleModule", new Version(1,0,0,null));
simpleModule.addSerializer(new JsonSerializer< Duck > {
    @Override
    public void serialize(Duck duck, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("name", duck.getName());
        jgen.writeEndObject();
    }
});
mapper.registerModule(simpleModule);