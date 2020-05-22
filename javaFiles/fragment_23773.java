JsonParser jsonParser = new JsonParser();
    JsonElement jo = jsonParser.parse(jsonGeneric);
    while (!jo.isJsonNull()) {
        System.out.println(jo.getAsJsonObject().get("description").getAsString());
        System.out.println(jo.getAsJsonObject().get("value").getAsString());
        jo = jo.getAsJsonObject().get("cat");
    }