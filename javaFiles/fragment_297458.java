JsonObject result = p.parse(file).getAsJsonObject();
Set<Map.Entry<String, JsonElement>> entrySet = result.entrySet();
for(Map.Entry<String, JsonElement> entry : entrySet) {
    User newUser = gson.fromJson(p.getAsJsonObject(entry.getKey()), User.class);
    newUser.username = entry.getKey();
    //code...
}