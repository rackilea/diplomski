class UserActionDeserializer implements JsonDeserializer<UserAction> {
    public UserAction deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException {
        return new UserAction(UUID.fromString(json.getAsString());
}

GsonBuilder gson = new GsonBuilder();
gson.registerTypeAdapter(UserAction.class, new UserActionDeserializer());