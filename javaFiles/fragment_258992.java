public static class LiteralAsObjectConverter<T> implements Converter<T> {
    private final Converter<T> concreteConverter;

    public LiteralAsObjectConverter(Converter<T> concreteConverter) {
        this.concreteConverter = concreteConverter;
    }

    @Override
    public void serialize(T object, ObjectWriter writer, Context ctx) throws Exception {
        writer.beginObject().writeName("value");
        concreteConverter.serialize(object, writer, ctx);
        writer.endObject();
    }

    @Override
    public T deserialize(ObjectReader reader, Context ctx) throws Exception {
        reader.beginObject();
        T instance = null;
        while (reader.hasNext()) {
            reader.next();
            if (reader.name().equals("value")) instance = concreteConverter.deserialize(reader, ctx);
            else throw new IllegalStateException(String.format("Encountered unexpected property named '%s'", reader.name()));
        }
        reader.endObject();
        return instance;
    }
}