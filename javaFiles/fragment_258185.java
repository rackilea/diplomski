final class Photo {

    final String url;

    private Photo(final String url) {
        this.url = url;
    }

    static final class Deserializer
            implements JsonDeserializer<Photo> {

        @Override
        public Photo deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) {
            final JsonObject jsonObject = jsonElement.getAsJsonObject();
            return new Photo(
                    // jsonObject.get("url").getAsString() can be more simple, but it does not respect Gson instance configuration
                    context.deserialize(jsonObject.get("url"), String.class)
            );
        }

    }

}