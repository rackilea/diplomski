final class MultimapTypeAdapter<K, V>
        extends TypeAdapter<Multimap<K, V>> {

    private final Converter<K, String> keyConverter;
    private final Function<? super K, ? extends TypeAdapter<V>> valueTypeAdapterProvider;

    private MultimapTypeAdapter(
            final Converter<K, String> keyConverter,
            final Function<? super K, ? extends TypeAdapter<V>> valueTypeAdapterProvider
    ) {
        this.keyConverter = keyConverter;
        this.valueTypeAdapterProvider = valueTypeAdapterProvider;
    }

    static <K, V> TypeAdapter<Multimap<K, V>> multimapTypeAdapter(
            final Converter<K, String> keyConverter,
            final Function<? super K, ? extends TypeAdapter<V>> valueTypeAdapterProvider
    ) {
        return new MultimapTypeAdapter<>(keyConverter, valueTypeAdapterProvider).nullSafe();
    }

    @Override
    @SuppressWarnings("resource")
    public void write(final JsonWriter jsonWriter, final Multimap<K, V> multimap)
            throws IOException {
        jsonWriter.beginObject();
        for ( final K key : multimap.keySet() ) {
            jsonWriter.name(keyConverter.convert(key));
            final TypeAdapter<? super V> typeAdapter = valueTypeAdapterProvider.apply(key);
            jsonWriter.beginArray();
            for ( final V value : multimap.get(key) ) {
                typeAdapter.write(jsonWriter, value);
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    @Override
    public Multimap<K, V> read(final JsonReader jsonReader)
            throws IOException {
        final ImmutableMultimap.Builder<K, V> multimapBuilder = new ImmutableMultimap.Builder<>();
        jsonReader.beginObject();
        while ( jsonReader.hasNext() ) {
            final K key = keyConverter.reverse().convert(jsonReader.nextName());
            final TypeAdapter<V> typeAdapter = valueTypeAdapterProvider.apply(key);
            jsonReader.beginArray();
            while ( jsonReader.hasNext() ) {
                final V value = typeAdapter.read(jsonReader);
                multimapBuilder.put(key, value);
            }
            jsonReader.endArray();
        }
        jsonReader.endObject();
        return multimapBuilder.build();
    }

}