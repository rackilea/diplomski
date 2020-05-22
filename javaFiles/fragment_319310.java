public class ResponseSerializer extends JsonSerializer<AnimalWrapper> {


    @Override
    public void serialize(AnimalWrapper value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        final Object animal = value.getAnimal();
        Class<?> responseClass = animal.getClass();
        JavaType responseJavaType = serializers.constructType(responseClass);
        gen.writeStartObject();
        gen.writeFieldName(serializers.findTypeSerializer(responseJavaType).getTypeIdResolver().idFromValue(animal));
        serializers.findValueSerializer(responseClass).serialize(animal, gen, serializers);
        /* Here you must manually serialize other properties */
        /* Like gen.writeStringField("property", value.getProperty()); */
        gen.writeEndObject();
    }
}