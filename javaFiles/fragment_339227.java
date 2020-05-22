public class BigDecimalToStringSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException,
        JsonProcessingException {
    if (pojo instanceof Price && ((Price) pojo).shouldConvertInString()) {
        gen.writeString(value.toString());
    } else {
        gen.writeNumber(value);
    }
    }