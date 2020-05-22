import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        String input = "{\r\n" + 
                "  \"info\": \"processing\",\r\n" + 
                "  \"data\": {\r\n" + 
                "    \"id\": \"123\",\r\n" + 
                "    \"cars\": [\r\n" + 
                "      {\r\n" + 
                "        \"id\": \"1\"\r\n" + 
                "      },\r\n" + 
                "      {\r\n" + 
                "        \"id\": \"2\"\r\n" + 
                "      }\r\n" + 
                "    ]\r\n" + 
                "  }\r\n" + 
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Process process = mapper.readValue(input, Process.class);
        System.out.println(process.getInfo());
        Data data = process.getData();
        List<Car> cars = data.getCars();
        for(Car car : cars) {
            System.out.println(car.getId());
        }

    }

}