public class JacksonVariableNames {

    static final String JSON = "{\n"
            + "  \"a\": {\n"
            + "    \"value\": \"1\"\n"
            + "  },\n"
            + "  \"b\": {\n"
            + "    \"value\": \"2\"\n"
            + "  },\n"
            + "  \"c\": {\n"
            + "    \"value\": \"3\"\n"
            + "  }\n"
            + "}";
    static class Value {
        private final String value;

        @JsonCreator
        Value(@JsonProperty("value") final String value) {this.value = value;}

        @Override
        public String toString() {
            return "Value{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    static class Values {
        private final Map<String, Value> values = new HashMap<>();

        @JsonAnySetter
        public void setValue(final String property, final Value value) {
            values.put(property, value);
        }

        @Override
        public String toString() {
            return "Values{" +
                    "values=" + values +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(JSON, Values.class));

    }
}