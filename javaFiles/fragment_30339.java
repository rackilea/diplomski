public class JsonMyDateSerializer extends JsonSerializer<MyDate> {

    @Override
    public void serialize(MyDate myDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        // Just an example....   convert your myDate something the jsonGenerator can handle
        jsonGenerator.writeString(myDate.toString());

    }
}