final class ObservableStringValueTypeAdapter
        extends TypeAdapter<ObservableStringValue> {

    private static final TypeAdapter<ObservableStringValue> observableStringValueTypeAdapter = new ObservableStringValueTypeAdapter();

    private ObservableStringValueTypeAdapter() {
    }

    static TypeAdapter<ObservableStringValue> getObservableStringValueTypeAdapter() {
        return observableStringValueTypeAdapter;
    }

    @Override
    @SuppressWarnings("resource")
    public void write(final JsonWriter out, final ObservableStringValue value)
            throws IOException {
        out.value(value.get());
    }

    @Override
    public ObservableStringValue read(final JsonReader in)
            throws IOException {
        return new SimpleStringProperty(in.nextString());
    }

}