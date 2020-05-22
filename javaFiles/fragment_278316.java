public class ResultDeserializer implements JsonDeserializer<Result> {

    @Override
    public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray array = json.getAsJsonArray();

        Result result = new Result();
        result.title = array.get(0).getAsString();

        result.results = new LinkedHashMap<String, Integer>();
        for(Entry<String, JsonElement> entry : array.get(1).getAsJsonObject().entrySet()) {
            result.results.put(entry.getKey(), entry.getValue().getAsInt());
        }

        return result;
    }   
}