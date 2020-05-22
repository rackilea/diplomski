@JsonRootName("Test1")
class Foo {
    @JsonProperty("Test2")
    List<List<Object>> bar;

    public static void main(String[] args) throws Exception {
        Foo foo = new ObjectMapper()
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .readValue(new File("test.json"), Foo.class);
        System.out.println(foo.bar);
    }
}