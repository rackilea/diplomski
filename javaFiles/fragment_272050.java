public class JsonTest {
public static void main(String[] args) throws Exception {
    final String json
        = "[\n"
        + "    {\n"
        + "        \"a\":\"b\",\n"
        + "        \"c\":\"d\"\n"
        + "    },\n"
        + "    {\n"
        + "        \"e\":\"f\",\n"
        + "        \"g\":\"h\",\n"
        + "        \"i\":\"j\"\n"
        + "    },\n"
        + "    {\n"
        + "        \"h\":\"k\"\n"
        + "    }\n"
        + "]"; // [{a:b,c:d},{e:f,g:h,i:j},{h:k}]   
    ObjectMapper mapper = new ObjectMapper();
    TypeFactory factory = TypeFactory.defaultInstance();
    List<Map<String, String>> list = mapper.readValue(json,factory
        .constructCollectionType(List.class, factory
                .constructMapType(Map.class, String.class, String.class)));
    System.out.println(list.toString());
}
}