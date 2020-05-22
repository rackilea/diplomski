@FunctionalInterface
public interface GenericTypeAdapterFactory
        extends TypeAdapterFactory {

    TypeAdapter<?> createUnchecked(Gson gson, TypeToken<?> typeToken);

    @Override
    default <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) createUnchecked(gson, typeToken);
        return castTypeAdapter;
    }

}