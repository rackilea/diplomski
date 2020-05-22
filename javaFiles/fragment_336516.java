public class MyDictionaryConverter implements JsonDeserializer<Map<?, ?>> {
    public Map<Object, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) {
        Type[] keyAndValueTypes = $Gson$Types.getMapKeyAndValueTypes(typeOfT, $Gson$Types.getRawType(typeOfT));

        Map<Object, Object> vals = new HashMap<Object, Object>();
        for (JsonElement item : json.getAsJsonArray()) {
            Object key = ctx.deserialize(item.getAsJsonObject().get("Key"), keyAndValueTypes[0]);
            Object value = ctx.deserialize(item.getAsJsonObject().get("Value"), keyAndValueTypes[1]);
            vals.put(key, value);
        }
        return vals;
    }
}