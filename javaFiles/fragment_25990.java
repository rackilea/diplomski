public class BaseModelForeignKeyTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!BaseModel.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        TypeAdapter defaultAdapter = gson.getAdapter(type);

        //noinspection unchecked
        return (TypeAdapter<T>) new Adapter(defaultAdapter);
    }

    private static class Adapter<T extends BaseModel> extends TypeAdapter<T> {

        private final TypeAdapter<T> defaultAdapter;

        Adapter(TypeAdapter<T> defaultAdapter) {
            this.defaultAdapter = defaultAdapter;
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            out.value(value.getId());
        }

        @Override
        public T read(JsonReader in) throws IOException {
            return defaultAdapter.read(in);
        }
    }
}