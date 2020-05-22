public static class SimplePojo {

    @JsonProperty
    @JsonSerialize(using=NumericBooleanSerializer.class)
    @JsonDeserialize(using=NumericBooleanDeserializer.class)
    Boolean bool;
}

public static class NumericBooleanSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean bool, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeString(bool ? "1" : "0");
    }   
}

public static class NumericBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        return !"0".equals(parser.getText());
    }       
}

@Test
public void readAndWrite() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    // read it
    SimplePojo sp = mapper.readValue("{\"bool\":\"0\"}", SimplePojo.class);
    assertThat(sp.bool, is(false));

    // write it
    StringWriter writer = new StringWriter();
    mapper.writeValue(writer, sp);
    assertThat(writer.toString(), is("{\"bool\":\"0\"}"));
}