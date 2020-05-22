public class GenericTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        // here should be checked if the passed type needs any custom 
        // adapter and if it needs then decide  which adapter to return
        // or in case of no customization needed return null for default
        // adapter.
        // decision can be made for example by
        // * type itself
        // * package name
        // * if type implements / extends some super type
        return new GenericTypeAdapter<>(type);
    }       
}