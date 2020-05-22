Map<String[],Boolean> map = new HashMap<>();
map.put(new String[]{"Hello"},false);
map.put(new String[]{"Stack", "Overflow"},true);

Type t = new TypeToken<Map<String[], Boolean>>(){}.getType();

Gson gson = new GsonBuilder().registerTypeAdapter(t, new MapSerializer())
                             .registerTypeAdapter(t, new MapDeserializer())
                             .setPrettyPrinting()
                             .create();

String repr =  gson.toJson(map, t);
Map<String[], Boolean> map2 = gson.fromJson(repr, t);