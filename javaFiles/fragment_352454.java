@JsonIgnoreProperties(ignoreUnknown = true)
    @JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Test {

        @JsonProperty("id")
        private String id;
        @JsonProperty("userId")
        private int userId;
        @JsonProperty("contentId")
        private int contentId;
       public Test() {

    }

    @JsonCreator
    public static Test getJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Test.class);
    }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getContentId() {
            return contentId;
        }

        public void setContentId(String contentId) {
            this.contentId = contentId;
        }
         public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }