public class JsonOrgJacksonTest {

    private final String json =
            "{" +
            "  \"id\": \"one\"," +
            "  \"content\": {" +
            "    \"foo\": \"bar\"," +
            "    \"baz\": \"blah\"" +
            "  }" +
            "}";

    @Test
    public void testJsonOrg() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JsonOrgModule());

        Model model = mapper.readValue(json, Model.class);

        assertThat(model.getId()).isEqualTo("one");
        assertThat(model.getContent().get("foo")).isEqualTo("bar");
        assertThat(model.getContent().get("baz")).isEqualTo("blah");
    }

    public static class Model {
        private String id;
        private JSONObject content;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public JSONObject getContent() { return content; }
        public void setContent(JSONObject content) { this.content = content; }
    }
}