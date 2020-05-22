GsonBuilder gsonBuilder = new GsonBuilder();

gsonBuilder.registerTypeAdapter(ObjMapStore.class, new JsonDeserializer<ObjMapStore>() {
    public ObjMapStore deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ObjMapStore objMapStore = new ObjMapStore();
        JsonObject jo = json.getAsJsonObject();
        objMapStore.put("param4", jo.get("param4").getAsInt());
        objMapStore.put("param5", jo.get("param5").getAsInt());
        objMapStore.put("param6", jo.get("param6").getAsInt());
        return objMapStore;
    }
});

Gson gson = gsonBuilder.create();