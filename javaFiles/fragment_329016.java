final class ContentJsonDeserializer<T>
        implements JsonDeserializer<Content<T>> {

    // This deserializer holds no state
    private static final JsonDeserializer<?> contentJsonDeserializer = new ContentJsonDeserializer<>();

    private ContentJsonDeserializer() {
    }

    // ... and we hide away that fact not letting this one to be instantiated at call sites
    static <T> JsonDeserializer<T> getContentJsonDeserializer() {
        // Narrowing down the @SuppressWarnings scope -- suppressing warnings for entire method may be harmful
        @SuppressWarnings("unchecked")
        final JsonDeserializer<T> contentJsonDeserializer = (JsonDeserializer<T>) ContentJsonDeserializer.contentJsonDeserializer;
        return contentJsonDeserializer;
    }

    @Override
    public Content<T> deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String responseType = jsonObject.getAsJsonPrimitive("type").getAsString();
        switch ( responseType ) {
        case "success":
            return success(context.deserialize(jsonObject.get("data"), getTypeParameter0(type)));
        case "error":
            return error(context.deserialize(jsonObject.get("data"), ApiError.class));
        default:
            throw new JsonParseException(responseType);
        }
    }

    // Trying to detect any given type parameterization for its first type parameter
    private static Type getTypeParameter0(final Type type) {
        if ( !(type instanceof ParameterizedType) ) {
            return Object.class;
        }
        return ((ParameterizedType) type).getActualTypeArguments()[0];
    }

}