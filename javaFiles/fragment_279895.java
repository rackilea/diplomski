public class CarSerializer implements JsonSerializer<Car> {
    private final Gson gson = new GsonBuilder()
            .addSerializationExclusionStrategy(new FieldExclusionStrategy()).create();

    @Override
    public JsonElement serialize(Car arg0, Type arg1, JsonSerializationContext arg2) {
        return new JsonParser().parse(gson.toJson(arg0));
    }
}