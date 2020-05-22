class BooleanJsonDeserializer implements JsonDeserializer<Boolean> {

    private final Set<String> TRUE_STRINGS = new HashSet<>(Arrays.asList("true", "1", "yes"));

    @Override
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println(json);
        JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive();
        if (jsonPrimitive.isBoolean()) {
            return jsonPrimitive.getAsBoolean();
        } else if (jsonPrimitive.isNumber()) {
            return jsonPrimitive.getAsNumber().intValue() == 1;
        } else if (jsonPrimitive.isString()) {
            return TRUE_STRINGS.contains(jsonPrimitive.getAsString().toLowerCase());
        }

        return false;
    }
}