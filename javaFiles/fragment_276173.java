public class CustomJsonSerializer extends StdSerializer<AbstractEntity> {

  public CustomJsonSerializer() {
    this(null);
  }

  public CustomJsonSerializer(Class<AbstractEntity> t) {
    super(t);
  }

  @Override
  public void serialize(AbstractEntity value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
    Field[] fields = value.getClass().getDeclaredFields();
    jgen.writeStartObject();

    for (Field field : fields) {
        field.setAccessible(true);

       try {
           // Do the proper field mapping for field types . Object type example
           jgen.writeObjectField(field.getName(), field.get(value));

        } catch (Exception e) {
          // catch error
        }
    }

    jgen.writeEndObject();
  }
}