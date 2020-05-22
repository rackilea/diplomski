private JsonObject returnRaw() {

    JsonObject gson = new JsonObject();

    try {

        JSONObject jsonObj_ = new JSONObject();
        jsonObj_.put("username", "plantdg");
        jsonObj_.put("password", "1234");
        JsonParser jsonParser = new JsonParser();
        gson = (JsonObject) jsonParser.parse(jsonObj_.toString());

    } catch (JSONException e) {
        e.printStackTrace();
    }

    return gson;
}