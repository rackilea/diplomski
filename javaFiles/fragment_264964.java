final class ArrayOrEmptyStringTypeAdapter<E>
        extends TypeAdapter<List<E>> {

    private final Gson gson;
    private final Type elementType;

    private ArrayOrEmptyStringTypeAdapter(final Gson gson, final Type elementType) {
        this.gson = gson;
        this.elementType = elementType;
    }

    static <E> TypeAdapter<List<E>> getArrayOrEmptyStringTypeAdapter(final Gson gson, final Type elementType) {
        return new ArrayOrEmptyStringTypeAdapter<>(gson, elementType);
    }

    @Override
    public void write(final JsonWriter out, final List<E> list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> read(final JsonReader in)
            throws IOException {
        final JsonToken token = in.peek(); // Peek the next token
        switch ( token ) {
        case BEGIN_ARRAY: // If it's an array begin `[`, then parse it as an array
            return parseAsArray(in);
        case STRING: // Or if it's a string, parse it in another way
            return parseAsString(in);
        default:
            throw new MalformedJsonException("Unexpected token: " + token);
        }
    }

    private List<E> parseAsArray(final JsonReader in)
            throws IOException {
        final List<E> list = new ArrayList<>();
        in.beginArray(); // Consume `[` from the token stream
        while ( in.peek() != END_ARRAY ) {
            final E element = gson.fromJson(in, elementType); // Delegate downstream parsing to the Gson instance
            list.add(element);
        }
        in.endArray(); // Consume `]` from the token stream
        return list;
    }

    private List<E> parseAsString(final JsonReader in)
            throws IOException {
        in.skipValue(); // in.nextString() consumes more memory accumulating the result
        return new ArrayList<>(); // Or null -- up to you. Or even Collections.emptyList(), but Gson uses mutable lists so we do
    }

}