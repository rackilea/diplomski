public class MyResultObjectAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType()!= MyResultObject.class) return null;

        TypeAdapter<MyResultObject> defaultAdapter = (TypeAdapter<MyResultObject>) gson.getDelegateAdapter(this, type);
        return (TypeAdapter<T>) new MyResultObjectAdapter(defaultAdapter);
    }

    public class MyResultObjectAdapter extends TypeAdapter<MyResultObject> {

        protected TypeAdapter<MyResultObject> defaultAdapter;


        public MyResultObjectAdapter(TypeAdapter<MyResultObject> defaultAdapter) {
            this.defaultAdapter = defaultAdapter;
        }

        @Override
        public void write(JsonWriter out, MyResultObject value) throws IOException {
            defaultAdapter.write(out, value);
        }

        @Override
        public MyResultObject read(JsonReader in) throws IOException {
            /* 
            This is the critical part. So if the value is a string,
            Skip it (no exception) and return null.
            */
            if (in.peek() == JsonToken.STRING) {
                in.skipValue();
                return null;
            }
            return defaultAdapter.read(in);
        }
    }
}