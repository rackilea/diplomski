final class FlexiBigIntSerializer
        implements JsonSerializer<FlexiBigInt>, JsonDeserializer<FlexiBigInt> {

    private static final FlexiBigIntSerializer flexiBigIntSerializer = new FlexiBigIntSerializer();

    private FlexiBigIntSerializer() {
    }

    static FlexiBigIntSerializer getFlexiBigIntSerializer() {
        return flexiBigIntSerializer;
    }

    @Override
    public JsonElement serialize(final FlexiBigInt flexiBigInt, final Type type, final JsonSerializationContext context) {
        return new JsonPrimitive(flexiBigInt.bigInt);
    }

    @Override
    public FlexiBigInt deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context) {
        return new FlexiBigInt(json.getAsString());
    }

}