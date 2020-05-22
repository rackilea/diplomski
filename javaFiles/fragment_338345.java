import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Util {

    // Just as posted by prior post:
    public <T> List<T> getAPI(URL url, Class <T> clazz) throws JsonParseException, JsonMappingException, IOException {   
        // GET 
        ObjectMapper mapper = new ObjectMapper();        
        List<T> objs = mapper.readValue(url, TypeFactory.defaultInstance().constructParametrizedType(ArrayList.class, List.class, clazz));
        return objs;
    }

    // Test all together
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/comments");
        Util u = new Util();
        List<TestData> objs = u.getAPI(url, TestData.class);
        System.out.println(objs.get(0).getId());
    }
}