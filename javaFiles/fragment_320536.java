public class JacksonImmutable {
    public static class Series {

        private final int init;
        private final String key;
        private final String color;

        public Series(@JsonProperty("key") String key,
                      @JsonProperty("color") String color,
                      @JsonProperty("init") int init) {
            this.key = key;
            this.init = init;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Series{" +
                    "init=" + init +
                    ", key='" + key + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"init\":1,\"key\":\"min\",\"color\":\"767\"}";
        System.out.println(mapper.readValue(json, Series.class));
    }
}