import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class TestJackson {

public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String testJson = "{\n" + "  \"user\": {\n" + "    \"0\": {\n" + "      \"firstName\": \"Monica\",\n" + "      \"lastName\": \"Belluci\"\n" + "    },\n" + "    \"1\": {\n" + "      \"firstName\": \"John\",\n" + "      \"lastName\": \"Smith\"\n" + "    },\n" + "    \"2\": {\n" + "      \"firstName\": \"Owen\",\n" + "      \"lastName\": \"Hargreaves\"\n" + "    }\n" + "  }\n" + "}";
        User readValue = mapper.readValue(testJson, User.class);
        System.out.println("readValue = " + readValue);
    }
}