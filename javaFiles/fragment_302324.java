public class MyObjectDataSerializer extends StdSerializer<MyObjectData> {

    public MyObjectDataSerializer() {
        super(MyObjectData.class);
    }

    public void serialize(MyObjectData value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("objectId", value.getObjectId());

        generator.writeArrayFieldStart("columnName");
        generator.writeString("myCategory");
        generator.writeString("myCategoryId");
        generator.writeEndArray();

        generator.writeArrayFieldStart("columnValues");
        for (MyObjectRow row : value.getColumnValues()) {
            generator.writeStartArray();
            generator.writeString(row.getMyCategory());
            generator.writeNumber(row.getMyCategoryId());
            generator.writeEndArray();
        }
        generator.writeEndArray();


        generator.writeEndObject();
    }
}