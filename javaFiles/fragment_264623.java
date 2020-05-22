public class JacksonTest {

    public static void main(String[] args) throws Exception {
        String json = "{\"name\" : \"Catalina\"}";
        ObjectMapper deserializerMapper = new ObjectMapper();
        NamesHolder namesHolder = deserializerMapper.readValue(json, NamesHolder.class);
        System.out.println(toString(namesHolder));

        json = "{\"name\" : {\"First\" : \"Catalina\", \"Last\" : \"Kyle\"}}";
        namesHolder = deserializerMapper.readValue(json, NamesHolder.class);
        System.out.println(toString(namesHolder));
    }

    private static String toString(NamesHolder namesHolder) {
        if (namesHolder.hasStringName()) {
            return "Type: String, Value: " + namesHolder.getStringName();
        } else if (namesHolder.hasMapNames()) {
            return "Type: Map, Value: " + namesHolder.getMapNames();
        }
        return "Type: Unknown, Value: " + namesHolder;
    }
}

class NamesHolder {

    public Object name;

    public boolean hasStringName() {
        return name instanceof String;
    }

    public String getStringName() {
        return name.toString();
    }

    public boolean hasMapNames() {
        return name instanceof Map;
    }

    public Map<String, String> getMapNames() {
        return (Map<String, String>) name;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}