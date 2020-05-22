public class JacksonValue {
    public static class Bean {
        private final List<String> values;

        public Bean(List<String> values) {
            this.values = values;
        }

        @JsonValue
        public List<String> getValues() {
            return values;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Bean bean = new Bean(Arrays.asList("a", "b", "c"));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(bean));
    }
}