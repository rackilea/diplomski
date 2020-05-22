String json = "[{\"op\":\"replace\",\"path\":\"/path1\",\"value\":\"val1\"},{\"op\":\"replace\",\"path\":\"/path2\",\"value\":[{\"name\":\"val2\"},{\"name\":\"val3\"}]}]";

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Value.class, new ValueTypeAdapter());
    Gson gson = gsonBuilder.create();

    Item[] itemArr = gson.fromJson(json, Item[].class);

    String serialized = gson.toJson(itemArr);

    System.out.println("serialized:" + serialized);
    // NOTE: serialized output is same with incoming test value