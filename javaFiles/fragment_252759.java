public class ActionTest {

        @Test
        public void testObjectToJson() throws JsonProcessingException {

            Action action = new Action();
            action.setId("id");
            action.setUsername("username");
            action.setApplicationId("applicationId");
            action.setName("name");
            action.setTimeStamp("timestamp");
            Map<String, String> map = Maps.newHashMap();
            map.put("key", "value");
            map.put("key2", "value2");
            action.setOptions(map);

            ObjectMapper mapper = new ObjectMapper();

            String value = mapper.writeValueAsString(action);
            System.out.println(value);
        }

        @Test
        public void testJsonToObject() throws IOException {

            String json = "{\"id\":\"id\",\"name\":\"name\",\"applicationId\":\"applicationId\",\"timeStamp\":\"timestamp\",\"username\":\"username\",\"options\":{\"key\":\"value\", \"key2\":\"value2\"}}";

            ObjectMapper mapper = new ObjectMapper();

            Action value = mapper.readValue(json, Action.class);
            System.out.println(value);
        }
    }

    class Action {

        private String id;
        private String name;
        private String applicationId;
        private String timeStamp;
        private String username;
        private Map<String, String> options;

        public Action() {}

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Action{");
            sb.append("id='").append(id).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append(", applicationId='").append(applicationId).append('\'');
            sb.append(", timeStamp='").append(timeStamp).append('\'');
            sb.append(", username='").append(username).append('\'');
            sb.append(", options=").append(options);
            sb.append('}');
            return sb.toString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Map<String, String> getOptions() {
            return options;
        }

        public void setOptions(Map<String, String> options) {
            this.options = options;
        }
    }