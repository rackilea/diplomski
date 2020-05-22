public class RoomSerializer extends StdSerializer<Room> {

    public RoomSerializer() {
        this(null);
    }

    public RoomSerializer(Class<Room> t) {
        super(t);
    }

    @Override
    public void serialize(Room value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("roomId", value.getRoomId());
        jgen.writeStringField("roomName", value.getRoomName());

        // Here we determine the field name depending on the type
        String roomDetailsFieldName = value.getRoomDetails().getClass().getSimpleName();
        jgen.writeObjectField(roomDetailsFieldName, value.getRoomDetails());

        jgen.writeEndObject();
    }
}