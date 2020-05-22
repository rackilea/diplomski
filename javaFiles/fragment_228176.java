JsonElement je = new JsonParser().parse(s);
    JsonObject asJsonObject = je.getAsJsonObject();
    JsonElement get = asJsonObject.get("address");
    System.out.println(s + "\n" + get);
    JsonObject asJsonObject1 = get.getAsJsonObject();
    JsonElement get1 = asJsonObject1.get("housename");
    System.out.println(get1);