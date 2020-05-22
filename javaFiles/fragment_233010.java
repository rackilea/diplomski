gsonBuilder.registerTypeAdapter(Pair.class, new PairCustomSerializer());

public class PairCustomSerializer implements JsonSerializer<Pair<?, ?>> {

        @Override
        public JsonElement serialize(Pair<?, ?> src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject obj = new JsonObject();
            JsonArray arr = new JsonArray();
            if (src.getFirst() instanceof Double) {
                Double val1 = (Double) src.getFirst();
                Double val2 = (Double) src.getSecond();
                arr.add(val1);
                arr.add(val2);
                obj.add("value", arr);
                return obj;
}