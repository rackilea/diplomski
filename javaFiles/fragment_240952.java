public class RouteResponseTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType() == RouteResponse.class) {
            return (TypeAdapter<T>)new RouteResponseTypeAdapter(gson);
        }
        return null;
    }
}