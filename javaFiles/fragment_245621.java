public class Main {
    public static String json1 = "{\"data\":[{\"count\":123,\"text\":\"abc\"}]}";
    public static String json2 = "{\"data\":[\"abc\"]}";
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(json1, MyRequestItem.class));
        System.out.println(mapper.readValue(json2, MyRequestItem.class));
    }

    @Data //  lombok.Data;
    @ToString // lombok.ToString;
    public static class MyRequestItem {
        private List<TextItem> data;
        @JsonCreator
        public MyRequestItem(@JsonProperty("data") ArrayList<TextItem> data) {
            this.data = data;
        }
    }

    @Data
    @ToString
    public static class TextItem {
        private int count;
        private String text;
        @JsonCreator
        public TextItem(@JsonProperty("count") int count,
                        @JsonProperty("text") String text) {
            this.count = count;
            this.text = text;
        }

        // this is the only thing you need to add to make it work
        public TextItem( String text) {
            this.text = text;
        }
    }
}