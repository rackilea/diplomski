final class ClassAwareSerializer<T>
        implements JsonSerializer<T>, JsonDeserializer<T> {

    private static final String CLASS_FIELD_NAME = "\u0001$class";

    private final Class<T> expectedClass;
    private final Supplier<Gson> gsonSupplier;

    private ClassAwareSerializer(final Class<T> expectedClass, final Supplier<Gson> gsonSupplier)
            throws IllegalArgumentException {
        this.expectedClass = expectedClass;
        this.gsonSupplier = gsonSupplier;
    }

    static <T> ClassAwareSerializer<T> getClassAwareSerializer(final Class<T> expectedClass, final Supplier<Gson> gsonSupplier) {
        return new ClassAwareSerializer<>(expectedClass, gsonSupplier);
    }

    @Override
    public JsonElement serialize(final T o, final Type type, final JsonSerializationContext context) {
        if ( o == null ) {
            return JsonNull.INSTANCE;
        }
        final Class<?> actualClass = o.getClass();
        requireExpectedClass(expectedClass, actualClass);
        final Gson gson = gsonSupplier.get();
        final JsonObject jsonObject = gson.toJsonTree(o).getAsJsonObject();
        jsonObject.addProperty(CLASS_FIELD_NAME, actualClass.getName());
        return jsonObject;
    }

    @Override
    public T deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        try {
            final JsonObject jsonObject = json.getAsJsonObject();
            final String className = jsonObject.get(CLASS_FIELD_NAME).getAsString();
            @SuppressWarnings("unchecked")
            final Class<T> actualClass = (Class<T>) Class.forName(className);
            requireExpectedClass(expectedClass, actualClass);
            final Gson gson = gsonSupplier.get();
            return gson.fromJson(json, actualClass);
        } catch ( final ClassNotFoundException ex ) {
            throw new JsonParseException(ex);
        } catch ( final Exception ex ) {
            final String name = getClass().getName();
            throw new JsonParseException(name + " cannot handle " + type, ex);
        }
    }

    private static void requireExpectedClass(final Class<?> expectedClass, final Class<?> actualClass) {
        if ( !expectedClass.isAssignableFrom(actualClass) ) {
            throw new IllegalArgumentException(actualClass + " is not assignable from " + expectedClass);
        }
    }

}