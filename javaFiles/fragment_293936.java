final class ObservableListTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory observableListTypeAdapterFactory = new ObservableListTypeAdapterFactory();

    private ObservableListTypeAdapterFactory() {
    }

    static TypeAdapterFactory getObservableListTypeAdapterFactory() {
        return observableListTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        if ( ObservableList.class.isAssignableFrom(typeToken.getRawType()) ) {
            final ParameterizedType parameterizedType = (ParameterizedType) typeToken.getType();
            final Class<?> elementClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
            final TypeAdapter<?> elementTypeAdapter = gson.getAdapter(elementClass);
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> objectObservableListTypeAdapter = (TypeAdapter<T>) getObservableListTypeAdapter(elementTypeAdapter);
            return objectObservableListTypeAdapter;
        }
        return null;
    }

}