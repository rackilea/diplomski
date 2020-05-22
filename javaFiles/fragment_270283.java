JsonParser parser =  new JsonParser();

JsonElement jsonElement = parser.parse(json);
JsonObject jsonObj = jsonElement.getAsJsonObject();

JsonArray feed = new JsonArray();
feed = jsonObj.getAsJsonArray("feed");

JsonObject jsonOb = feed.get(0).getAsJsonObject();
String value = jsonOb.get("cat2").getAsString();