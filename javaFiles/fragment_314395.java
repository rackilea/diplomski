public class Test {
    public static void main(String[] args) throws Exception {
        String jsonTextFromDb = "{\"race\": \"dog\"}";

        JsonElement additionalProperties = new JsonParser().parse(jsonTextFromDb);
        Animal animal = new Animal("Mia", additionalProperties, jsonTextFromDb);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(animal));
    }
}

class Animal {
    private String name;
    private JsonElement additionalProperties;
    @JsonAdapter(JsonTextAdapter.class)
    private String additionalProperties2;
    Animal(String name, JsonElement additionalProperties, String additionalProperties2) {
        this.name = name;
        this.additionalProperties = additionalProperties;
        this.additionalProperties2 = additionalProperties2;
    }
}

class JsonTextAdapter extends TypeAdapter<String> {
    @Override
    public void write(JsonWriter out, String str) throws IOException {
        out.jsonValue(str);
    }
    @Override
    public String read(JsonReader in) throws IOException {
        return new JsonParser().parse(in).toString();
    }
}