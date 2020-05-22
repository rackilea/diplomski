Gson gson = new GsonBuilder().registerTypeAdapter(Result.class, new ResultDeserializer()).create();

Results results = gson.fromJson(json, Results.class);

for(Result r : results.results) {
    System.out.println("Title = " + r.title);
    for(Entry<String, Integer> entry : r.results.entrySet()) {
        System.out.println("\t " + entry.getKey() + " -> " + entry.getValue());
    }
}