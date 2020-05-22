public class Test {
    public int a;

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper(null, null, new ReportingDeserializationContext());
        Test jc = objectMapper.readValue("{ \"a\": 10, \"b\": 11, \"c\": 12 }", Test.class);
        System.out.println(jc.a);
    }
}