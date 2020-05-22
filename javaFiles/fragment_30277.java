class ChatMessageDezerializer implements JsonDeserializer<ChatMessage> {
    @Override
    public ChatMessage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ChatMessage message = new ChatMessage();
        JsonObject obj = json.getAsJsonObject();
        message.translate = obj.get("translate").getAsString();
        JsonArray array = obj.getAsJsonArray("with");
        message.with.add(context.deserialize(array.get(0), With.class));
        message.with.add(array.get(1).getAsString());
        return message;
    }
}