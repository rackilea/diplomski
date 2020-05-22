class MapperAdapter implements JsonDeserializer<Mapper> {

    private static final Pattern p = Pattern.compile("\\(\"([a-zA-Z\\d]+)\"\\)");

    @Override
    public Mapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObj = json.getAsJsonObject();
        String id = jObj.get("_id").getAsString();
        String name = jObj.get("name").getAsString();

        Matcher m = p.matcher(id);
        if(!m.find()) {
            throw new IllegalArgumentException("The id should be within parenthesis and quotes.");
        }
        return new Mapper(m.group(1), name);
    }
}