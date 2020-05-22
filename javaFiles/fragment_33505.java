import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        JsonWrapper wrapper = new JsonWrapper();
        wrapper.getTypes().put("rose", new Flower());
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(wrapper);
        System.out.println(jsonInString);

    }
}