import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Test
{
    public static void main(String[] args)
    {
        String input = "[{\"var1\":\"value1\",\"var2\":\"value2\"},{\"var2\":\"value22\",\"var3\":[[\"0\",\"1\",\"2\"],[\"3\",\"4\",\"5\"],[\"6\",\"7\",\"8\"]]}]" ;
        Map<String, String> result = new HashMap<>();  // final result, with duplicate keys handles and everything

        try {
            // ObjectMapper is Jackson json parser 
            ObjectMapper om = new ObjectMapper();
            // we need to tell ObjectMapper what type to parse into 
            // in this case: list of maps where key is string and value is some cimplex Object
            TypeFactory tf = om.getTypeFactory();
            JavaType mapType = tf.constructMapType(HashMap.class, String.class, Object.class);
            JavaType listType = tf.constructCollectionType(List.class, mapType);
            @SuppressWarnings("unchecked")
            // finally we parse the input into the data struct 
            List<Map<String, Object>> list = (List<Map<String, Object>>)om.readValue(input, listType);

            // post procesing: populate result, taking care of duplicates 
            for (Map<String, Object> listItem : list) {
                for (Map.Entry<String, Object> mapItem : listItem.entrySet()) {
                    String key = mapItem.getKey();
                    String value = mapItem.getValue().toString();
                    if (result.containsKey(key)) value = result.get(key) + "," + value;
                    result.put(key, value);
                }
            }

            // result sohuld hold expected outut now 
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}