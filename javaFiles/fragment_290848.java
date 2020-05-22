private static void deserializeViaObjectAccess(final String json)
{
    Gson gson = new Gson();

    // Read the whole JSON into meomory via GSON_DOM
    JsonParser parser = new JsonParser();
    JsonObject object1 = parser.parse(json).getAsJsonObject().getAsJsonObject("object1");

    // map the Object1 class via GSON_BIND
    // (bind common attributes which exist in JSON and as properties in the class)
    // mapper acts as factory
    Object1 result = gson.fromJson(object1, Object1.class);

    // manually read the attribute from the user object
    int userId = object1.getAsJsonObject("user").getAsJsonPrimitive("id").getAsInt();
    result.setUserId(userId);

    // manually read the attributes from the example object
    String names = "";
    JsonArray list = object1.getAsJsonObject("example").getAsJsonArray("list");
    for (int i = 0; i < list.size(); ++i)
    {
        JsonObject entry = list.get(i).getAsJsonObject();
        String name = entry.getAsJsonPrimitive("name").getAsString();

        names = i == 0 ? name : names + "; " + name;
    }
    result.setNameList(names);

    // Output the result
    log.debug(result.toString());
}