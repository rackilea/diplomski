@Override
public void serialize(Optional<?> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException {
    if(value.isPresent()){
        provider.defaultSerializeValue(value.get(), jgen);
    } else{
        // provider.defaultSerializeNull(jgen);
        // force writing null here instead of using default
    }
}