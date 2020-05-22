public class DistanceSerializer<T> extends StdSerializer<T> {

    public DistanceSerializer() {
        this(null);
    }

    protected DistanceSerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value + " km");
    }

}