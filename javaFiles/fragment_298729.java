public class CustomConvertor implements JsonDeserializer<Response> {

    @Override
    public Response deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        Response response = gson.fromJson(json, Response.class);

        if (response.getStatus().equals("success")) {
            // The full response as a json object
            final JsonObject jsonObject = json.getAsJsonObject();
            // The user attribute in the JSON received
            final JsonElement jsonElement = jsonObject.get("user");

            User user = gson.fromJson(jsonElement, User.class);
            response.setUser(user);
        }else{
            // you could do this
            // not needed as json is deserialized to Response already
            // just for the example
            final JsonObject jsonObject = json.getAsJsonObject();
            String reason = jsonObject.getAsJsonPrimitive("reason").getAsString();
            response.setReason(reason);
        }

        return response;
    }
}