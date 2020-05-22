final class User {

    final long id;
    final List<Photo> photos;

    private User(final long id, final List<Photo> photos) {
        this.id = id;
        this.photos = photos;
    }

    static final class Deserializer
            implements JsonDeserializer<User> {

        private static final Type photoListType = new TypeToken<List<Photo>>() {
        }.getType();

        @Override
        public User deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) {
            // Note that you must pick up properties first
            final JsonObject jsonObject = jsonElement.getAsJsonObject();
            return new User(
                    // And then delegate them to the deserialization context specifying the target type
                    context.deserialize(jsonObject.get("id"), long.class),
                    // You can deconstruct JsonElement recursively, but deserialization context respects Gson context built with GsonBuilder
                    // This also does trigger the Photo.Deserializer
                    context.deserialize(jsonObject.get("photos"), photoListType)
            );
        }

    }

}