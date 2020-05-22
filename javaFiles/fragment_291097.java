public class TreeDeserializer implements JsonDeserializer<Tree> {

    public Tree deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        Tree out = new Tree();

        if (json != null) {
            JsonObject obj  = json.getAsJsonObject();
            Set<Map.Entry<String,JsonElement>> entries = obj.entrySet();
            for (Map.Entry<String, JsonElement> e: entries) {
                if (e.getKey().equals("allAllowedChildren")) {
                    Type ft = List.class;
                    System.out.println(context.deserialize(e.getValue(), ft));
                    // TODO add this back into the Tree out object
                } else {
                    // LocalLocationId
                    System.out.println(e.getKey());
                    System.out.println(context.deserialize(e.getValue(), Tree.LocalLocationId.class));

                    // TODO add this back into the Tree out object
                }
            }
        } 
        return out;
    }

}