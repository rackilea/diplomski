public class CustomClass implements JsonSerializable {

    @JsonProperty("Value")
    private boolean value;
    @JsonProperty("OtherObjects")
    private List<OtherObjects> objects;
    @JsonProperty("Num")
    private int num;
    @JsonIgnore
    public String dynamicParameterKey;


//We do this so Jackson will know how to serialize with dynamic parameter key
@Override
public void serialize(JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeStartObject();

    //use default serializer
    JavaType javaType = provider.constructType(RegulationAnswer.class);
    BeanDescription beanDesc = provider.getConfig().introspect(javaType);
    JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanSerializer(provider,
            javaType,
            beanDesc);
    serializer.unwrappingSerializer(null).serialize(this, gen, provider);

    //add custom fields
    gen.writeBooleanField(dynamicParameterKey, isChecked());

    gen.writeEndObject();
}

@Override
public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(gen, serializers);
}
}