public static List<Pattern> loadPattern(){
    ArrayList<Pattern> patterns = new ArrayList<>();
    Gson gson = new Gson();
    JsonParser jsonParser = new JsonParser();
    try {
        BufferedReader br = new BufferedReader(new FileReader("JsonObjects/objects.json"));
        JsonElement jsonElement = jsonParser.parse(br);

        //Create generic type
        Type type = new TypeToken<List<Pattern>>() {}.getType();
        return gson.fromJson(jsonElement, type);

    } catch (IOException e) {
        e.printStackTrace();
    }
    return patterns;        
}