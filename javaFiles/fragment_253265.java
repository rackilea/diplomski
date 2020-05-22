public class ExplorerDeserializerJson implements JsonDeserializer<Explorer> {

    @Override
    public Explorer deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {
        Explorer explorer = new Explorer();
        JsonArray jsonArray = je.getAsJsonArray();
        Gson gson = new Gson();
        for(JsonElement element : jsonArray){
            JsonObject jsonObject = element.getAsJsonObject();
            NataCenter nataCenter = gson.fromJson(jsonObject.get("nata_center"), NataCenter.class);
            explorer.add(nataCenter);
        }
        return explorer;

    }
}