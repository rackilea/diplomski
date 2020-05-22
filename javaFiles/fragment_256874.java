GsonBuilder b = new GsonBuilder();
b.registerTypeAdapter(Apple.class, new JsonDeserializer<Apple>() {
    @Override
    public Apple deserialize(JsonElement arg0, Type arg1,
        JsonDeserializationContext arg2) throws JsonParseException {
        JsonObject appleObj = arg0.getAsJsonObject();
        Gson g = new Gson();
        // Construct an apple (this shouldn't try to parse the seeds stuff
        Apple a = g.fromJson(arg0, Apple.class);
        List<Seed> seeds = null;
        // Check to see if we were given a list or a single seed
        if (appleObj.get("seeds").isJsonArray()) {
            // if it's a list, just parse that from the JSON
            seeds = g.fromJson(appleObj.get("seeds"),
                    new TypeToken<List<Seed>>() {
                    }.getType());
        } else {
            // otherwise, parse the single seed,
            // and add it to the list
            Seed single = g.fromJson(appleObj.get("seeds"), Seed.class);
            seeds = new ArrayList<Seed>();
            seeds.add(single);
        }
        // set the correct seed list
        a.setSeeds(seeds);
        return a;
    }
});