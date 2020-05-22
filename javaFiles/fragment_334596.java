public class HttpStatusSerializer extends StdSerializer<HttpStatus> {
    public HttpStatusSerializer() {
        super(HttpStatus.class);
    }

    @Override
    public void serialize(HttpStatus value, JsonGenerator gen, SerializerProvider serializers) { 
        gen.writeString(String.valueOf(value.code())); // or whatever you want
    }
}