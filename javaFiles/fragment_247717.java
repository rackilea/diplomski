public enum Status {
    ACTIVE,
    INACTIVE;
    public static Status fromTypeCode(final int typeCode) {
        switch(typeCode) {
        case 1: return ACTIVE;
        case 2: return INACTIVE;
        }
        throw new IllegalArgumentException("Invalid Status type code: " + typeCode);
    }
}

public class StatusDeserializer extends JsonDeserializer<Status> {
    @Override
    public Status deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        return Status.fromTypeCode(parser.getValueAsInt());
    }
}