public class BuildJson {
    private String key1 = "value1";
    private String key2 = "value2";
    private String key3 = "value3"; 
    private JsonElement key4;

public BuildJson(Object value4) {       
    key4 = new Gson().toJsonTree(value4);
}

public String buildJson(){      
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String new_json = gson.toJson(this);
    return new_json;
}
}