import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

        public class Test {

            public static void main(String[] args) throws IOException {

                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = "{\n" +
                        "    \"Red\": {\n" +
                        "        \"Level 1\": \"Specify Action\",\n" +
                        "        \"Level 2\": \"Action Taken\",\n" +
                        "        \"Level 3\": \"No Action Taken\"\n" +
                        "    },\n" +
                        "    \"Orange\": {\n" +
                        "        \"Level 4\": \"Defeat Gannon\",\n" +
                        "        \"Level 5\": \"Save Princess\",\n" +
                        "        \"Level 6\": \"Find Triforce\"\n" +
                        "    }\n" +
                        "}";

                TypeReference< Map<String, HashMap<String, String>>> typeRef
                        = new TypeReference<Map<String, HashMap<String, String>>>() {
                };

                Map<String, HashMap<String, String>> value = mapper.readValue(jsonInString, typeRef);

                System.out.println(value);

            }
        }