public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        Foo foo = new Foo();
        foo.setB(true);
        foo.setS("Test");
        foo.setI(39);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory jsonFactory = new JsonFactory();

        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(stringWriter);
        jsonGenerator.enable(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
        objectMapper.writeValue(jsonGenerator, foo);
        System.out.println(stringWriter);

        JsonParser jsonParser = jsonFactory.createJsonParser(stringWriter.toString());
        Foo value = objectMapper.readValue(jsonParser, Foo.class);
        System.out.println(value);
    }
}

class BooleanSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(value.toString());
    }
}

class BooleanDeserializer extends JsonDeserializer<Boolean> {

    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Boolean.valueOf(jsonParser.getValueAsString());
    }
}

class Foo {

    @JsonSerialize(using = BooleanSerializer.class)
    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean b;
    private String s;
    private int i;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Foo [b=" + b + ", s=" + s + ", i=" + i + "]";
    }
}