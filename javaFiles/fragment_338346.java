import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    // exactly like posted in my prior answer (despite exceptionhandling):
    public <T> List<T> getAPI(URL url, Class <T> clazz) throws JsonParseException, JsonMappingException, IOException {   
        // GET 
        ObjectMapper mapper = new ObjectMapper();        
        List<T> objs = mapper.readValue(url, new TypeReference<List<T>>(){});
        return objs;
    }

    // Test all together
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // thanks for this URL!
        URL url = new URL("https://jsonplaceholder.typicode.com/comments");
        Util u = new Util();
        List<TestData> objs = u.getAPI(url, TestData.class);
        System.out.println(objs.get(0).getId());
    }
}