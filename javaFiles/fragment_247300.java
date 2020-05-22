public abstract class ProtoDeserializer<T extends Message> {

    private final Parser<T> parser;

    public ProtoDeserializer(Parser<T> parser) {
        this.parser = parser;
    }

    public T deserialize(final byte[] bytes) throws Exception {    
        T message = parser.parseFrom(bytes);
        validate(message);
        return message;
    }

    public abstract void validate(final T message) throws Exception;
}