class LongOrDoubleTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (rawType == Long.class || rawType == long.class) {
            return new TypeAdapter<T>() {
                @Override
                public void write(JsonWriter out, T value) {
                }

                @Override
                public T read(JsonReader in) throws IOException {
                    try {
                        return (T) new Long(in.nextLong());
                    } catch (NumberFormatException e) {
                        return (T) new Long(((Double) in.nextDouble()).longValue());
                    }
                }
            };
        }
        return null;
    }
}