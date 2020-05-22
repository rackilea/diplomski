@Override
public void serialize(Double value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    if (value.intValue() == value)
        gen.writeNumber(value.intValue());
    else
        gen.writeNumber(value);
}