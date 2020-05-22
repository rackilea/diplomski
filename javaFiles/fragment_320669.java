class PgObjectSerializer extends JsonSerializer<Object> {
@Override
public void serialize(Object object, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    if (object instanceof PGobject) {
        PGobject pgObject = (PGobject) object;
        switch (pgObject.getType()) {
        case "json":
        case "jsonb":
                gen.writeRawValue(pgObject.getType());
                break;
        default:
                gen.writeString(pgObject.getType());
        }
        }else{
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(gen, object);
        }
    }
}