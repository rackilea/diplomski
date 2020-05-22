interface GsonTypeAdapterFactory<T>
        extends BiFunction<Gson, TypeToken<T>, TypeAdapter<T>> {
}

static <TF> TypeAdapterFactory wrap(final GsonTypeAdapterFactory<TF> factory) {
    return new TypeAdapterFactory() {
        @Override
        public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
            @SuppressWarnings("unchecked")
            final TypeToken<TF> castTypeToken = (TypeToken<TF>) typeToken;
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) factory.apply(gson, castTypeToken);
            return castTypeAdapter;
        }
    };
}