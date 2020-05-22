try (JsonReader jsonReader = new JsonReader(new FileReader(jsonFile))) {
    jsonReader.beginArray();
    while (jsonReader.hasNext()) {
        Way way = gson.fromJson(jsonReader, Way.class);
        if (way.getType().contentEquals("way")) {
            System.out.println(way.getId());
        }
    }
}