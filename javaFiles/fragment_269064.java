public class CustomSerializer extends JsonSerializer<LocalDateTime> {
@Override
public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    //add your custom date parser
    gen.writeString(value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()+"");
}
}