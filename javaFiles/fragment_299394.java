Map<String, JsonElement> resultMap;
Gson gson = new Gson();
Type type = new TypeToken<Map<String, JsonElement>>() {}.getType();
JsonElement jsonElement = gson.fromJson(DATA, JsonElement.class);
resultMap = gson.fromJson(jsonElement.toString(), type);

JsonArray details = resultMap.get("Details").getAsJsonArray();
JsonObject recordElement = details.get(0).getAsJsonObject();
System.out.println(recordElement.get("Id").getAsString());