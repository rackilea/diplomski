Gson gson = new GsonBuilder().create();

String[] jsons = {"[]", "[ ]", "[\r\n]", "{}", "{\"error\":\"Internal error\"}"};
for (String json : jsons) {
    JsonElement root = gson.fromJson(json, JsonElement.class);
    if (root.isJsonObject()) {
        JsonElement error = root.getAsJsonObject().get("error");
        System.out.println(error);
    }
}