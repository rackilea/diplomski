public class MyLocalTimeSerializer extends JsonSerializer<LocalTime> {

    @Override
    public void serialize(
            LocalTime time, 
            JsonGenerator gen, 
            SerializerProvider arg2) throws IOException, JsonProcessingException {
        gen.writeString(time.toString("HH:mm"));
    }

}