public class MultipleCharacteristicValueSerializer extends JsonSerializer<MultipleCharacteristic> {

    @Override
    public void serialize(MultipleCharacteristic multipleCharacteristicValue, JsonGenerator jsonGenerator,SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeFieldName("value");
        jsonGenerator.writeStartArray();
        for (AbstractCharacteristic<?> characteristicValue : multipleCharacteristicValue.getValue()) {
            jsonGenerator.writeObject(characteristicValue);
        }
        jsonGenerator.writeEndArray();
    }

    @Override
    public void serializeWithType(MultipleCharacteristic value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
        typeSer.writeTypePrefixForObject(value, jgen);
        serialize(value, jgen, provider);
        typeSer.writeTypeSuffixForObject(value, jgen);
    }

    @Override
    public Class<MultipleCharacteristic> handledType() {
        return MultipleCharacteristic.class;
    }
}