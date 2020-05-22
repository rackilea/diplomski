public class ParseTo {

    private Map<String, InnerParse> unknown = new HashMap<>();

    @JsonAnyGetter
    public Map<String, InnerParse> get(){
        return unknown;
    }

    @JsonAnySetter
    public void set(String key, Object value){
        if(value instanceof Map){
            Map<String, String> m = (Map<String, String>) value;
            unknown.put(key, new InnerParse(m));
        }
    }
}

public class InnerParse {

    private static final String V1_PROPERTY = "value_1";
    private static final String V2_PROPERTY = "value_2";

    public InnerParse(Map<String, String> map){
        this.value1 = map.get(V1_PROPERTY);
        this.value2 = map.get(V2_PROPERTY);
    }

    private String value1;
    private String value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}

public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"1\":{\n" +
            "       \"value_1\":\"something\",\n" +
            "       \"value_2\":\"something else\"},\n" +
            " \"2\": {\n" +
            "       \"value_1\":\"something\",\n" +
            "       \"value_2\":\"something else\"}" +
            "}";
        try {
            ParseTo parsed = new ObjectMapper().readValue(jsonString, ParseTo.class);

            parsed.get().entrySet().stream()
                .forEach(entry -> {
                    System.out.println("key: " + entry.getKey() + ", value: (" +
                        " Inner value1: " + entry.getValue().getValue1() + "," +
                        " Inner value2: " + entry.getValue().getValue2() +
                        ")");
                });

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}