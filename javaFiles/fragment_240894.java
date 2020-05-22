public class ResponseDeserializer implements JsonDeserializer<Response> {
    @Override
    public Response deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context)
            throws JsonParseException {
        // This is how to get the version
        Double version = json.getAsJsonObject().get("version").getAsDouble();
        // and below is jsut an example what you could do with version
        Gson gson = new GsonBuilder()
                .setVersion(version) // this is where @Since might be handy
                .setPrettyPrinting()
                .create();
        return gson.fromJson(json, Response.class);
    }
}