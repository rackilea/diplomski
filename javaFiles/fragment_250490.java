GsonBuilder gsonBuilder = new GsonBuilder();

gsonBuilder.registerTypeAdapter(ObjStore.class, new JsonDeserializer<ObjStore>() {
    public ObjStore deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ObjStore objStore = new ObjStore(true);
        JsonObject jo = json.getAsJsonObject();
        objStore.setParam4( jo.get("param4").getAsInt() );
        objStore.setParam5(jo.get("param5").getAsInt());
        objStore.setParam6(jo.get("param6").getAsInt());
        return objStore;
    }
});

Gson gson = gsonBuilder.create();