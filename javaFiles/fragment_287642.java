public class PostArrayOrSingleDeserializer implements JsonDeserializer<Post[]> {

    private static final Gson gson = new Gson();

    public Post[] deserialize(JsonElement json, Type typeOfT, 
                JsonDeserializationContext ctx) {
        try {
            return gson.fromJson(json.getAsJsonArray(), typeOfT);
        } catch (Exception e) {
            return new Post[] { gson.fromJson(json, Post.class) };
        }
    }
}