class UUIDDeserializer implements JsonDeserializer<UUID>
{
    @Override
    public UUID deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        return UUID.fromString(je.getAsString());
    }
}