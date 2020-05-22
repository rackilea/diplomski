class Data {
    private String name;
    private String type;
    private String[] value;

    //gettes and setters
}


public class Example {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper =
                new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        String json1 = "{\"name\":\"name\",\"type\":\"type\",\"value\":\"one\"}";
        String json2 = "{\"name\":\"name\",\"type\":\"type\",\"value\":[\"one\",\"two\"]}";

        Data data1 = mapper.readValue(json1, Data.class);
        Data data2 = mapper.readValue(json2, Data.class);
        System.out.println(data1);
        System.out.println(data2);
    }
}