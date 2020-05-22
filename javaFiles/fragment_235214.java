public String toJSON(){
    final Gson gson = new Gson();
    final JsonElement jsonTree = gson.toJsonTree(General, Map.class);
    final JsonObject jsonObject = new JsonObject();
    jsonObject.add("General", jsonTree);
    return jsonObject.toString();
}