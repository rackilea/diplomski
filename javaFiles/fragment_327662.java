public class BehaviorListAdapter implements JsonSerializer<List<Behavior>> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";

    @Override
    public JsonElement serialize(List<Behavior> src, Type typeOfSrc,
            JsonSerializationContext context) {
        JsonArray array = new JsonArray();
        for (Behavior behavior : src) {
            JsonObject behaviorJson = new JsonObject();
            String className = behavior.getClass().getCanonicalName();
            behaviorJson.addProperty(CLASSNAME, className);
            JsonElement elem = context.serialize(behavior);
            behaviorJson.add(INSTANCE, elem);
            array.add(behaviorJson);
        }
        return array;
    }
}

GsonBuilder builder = new GsonBuilder();
// use a TypeToken to make a Type instance for a parameterized type
builder.registerTypeAdapter(
    (new TypeToken<List<Behavior>>() {}).getType(),
    new BehaviorListAdapter());
gson = builder.create();