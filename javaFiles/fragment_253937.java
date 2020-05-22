/**
 * Custom deserializer for untyped objects that ensures integers are returned as longs
 */
public class ObjectDeserializer extends UntypedObjectDeserializer {

    private static final long serialVersionUID = 7764405880012867708L;

    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        Object out = super.deserialize(jp, ctxt);
        if (out instanceof Integer) {
            return Long.valueOf((Integer)out).longValue();
        }
        return out;
    }

    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt,
            TypeDeserializer typeDeserializer) throws IOException {

        Object out = super.deserializeWithType(jp, ctxt, typeDeserializer);
        if (out instanceof Integer) {
            return Long.valueOf((Integer)out).longValue();
        }
        return out;
    }
}