@Override
public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
{
    if (value instanceof Date) {
        provider.defaultSerializeDateKey((Date) value, jgen);
    } else {
        jgen.writeFieldName(value.toString());
    }
}