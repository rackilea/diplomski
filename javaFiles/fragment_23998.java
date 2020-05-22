import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./src/main/resources/test.json");

        ObjectMapper mapper = new ObjectMapper();

        TypeReference rootType = new TypeReference<List<Map<String, Object>>>() { };
        List<Map<String, Object>> root = mapper.readValue(jsonFile, rootType);
        Map<String, Object> result = root.stream()
                 .collect(Collectors.toMap(
                         m -> m.get("map").toString(),
                         m -> m.get("values")));
        System.out.println(result);
    }
}