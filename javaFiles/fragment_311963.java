import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSO {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, JSONException, IOException {
        String jsonString = "{\r\n" + 
                "    \"Container1\": {\r\n" + 
                "        \"active\": true\r\n" + 
                "    },\r\n" + 
                "    \"Container2\": {\r\n" + 
                "        \"active\": false\r\n" + 
                "    },\r\n" + 
                "}";

        JSONObject jsonObject = new JSONObject(jsonString);

        ObjectMapper mapper = new ObjectMapper();
        for (String key : jsonObject.keySet()) {
            Container container = mapper.readValue(jsonObject.get(key).toString(), Container.class);
            System.out.println(container);
        }   
    }

    static class Container{
        private String name;
        private Boolean active;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Boolean getActive() {
            return active;
        }
        public void setActive(Boolean active) {
            this.active = active;
        }
        @Override
        public String toString() {
            return "Container [name=" + name + ", active=" + active + "]";
        }
    }
}