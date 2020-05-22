final class ObservableListTypeAdapter<E>
        extends TypeAdapter<ObservableList<E>> {

    private final TypeAdapter<E> elementTypeAdapter;

    private ObservableListTypeAdapter(final TypeAdapter<E> elementTypeAdapter) {
        this.elementTypeAdapter = elementTypeAdapter;
    }

    static <E> TypeAdapter<ObservableList<E>> getObservableListTypeAdapter(final TypeAdapter<E> elementTypeAdapter) {
        return new ObservableListTypeAdapter<>(elementTypeAdapter);
    }

    @Override
    @SuppressWarnings("resource")
    public void write(final JsonWriter out, final ObservableList<E> value)
            throws IOException {
        out.beginArray();
        for ( final E element : value ) {
            elementTypeAdapter.write(out, element);
        }
        out.endArray();
    }

    @Override
    public ObservableList<E> read(final JsonReader in)
            throws IOException {
        final ObservableList<E> list = observableArrayList();
        in.beginArray();
        while ( in.peek() != END_ARRAY ) {
            list.add(elementTypeAdapter.read(in));
        }
        in.endArray();
        return list;
    }

}