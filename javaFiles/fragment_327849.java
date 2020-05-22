import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonReformatter {

    public static void main(String[] args) throws Exception {
        String jsonString = "{\"code\": \"0\",\"data\": [{\"chrDesigName\": \"Developer\",\"chrempName\": \"Test Employee1\"},{\"chrDesigName\": \"Developer\",\"chrempName\": \"Test Employee2\"},{\"chrDesigName\": \"Tester\",\"chrempName\": \"Test Employee3\"},{\"chrDesigName\": \"Analyst\",\"chrempName\": \"Test Employee4\"},{\"chrDesigName\": \"Developer\",\"chrempName\": \"Test Employee5\"},{\"chrDesigName\": \"Tester\",\"chrempName\": \"Test Employee6\"}]}";

        ObjectMapper mapper = new ObjectMapper();

        // Map<String, Object> dataMap = mapper.readValue(jsonString,
        // new TypeReference<Map<String, Object>>() {
        // });
        //
        // System.out.println(dataMap.get("data") +
        // ((ArrayList)dataMap.get("data")).get(0).getClass().getName()) ;

        JsonArray dataArray = new JsonParser().parse(jsonString).getAsJsonObject().getAsJsonArray("data");

        HashMap<String, List<String>> designationsMap = new HashMap<String, List<String>>();

        for (JsonElement element : dataArray) {
            String designation = element.getAsJsonObject().get("chrDesigName").getAsString();
            String empName = element.getAsJsonObject().get("chrempName").getAsString();
            if (designationsMap.containsKey(designation)) {
                designationsMap.get(designation).add(empName);
            } else {
                ArrayList<String> emptyList = new ArrayList<String>();
                emptyList.add(empName);
                designationsMap.put(designation, emptyList);
            }
        }

        StringWriter result = new StringWriter();
        mapper.writeValue(result, designationsMap);
        System.out.println(result);

    }

}