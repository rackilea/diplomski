import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FieldsMap<K, V> extends HashMap<K, V> {

    @Override
    public V get(Object field) {
        V value = super.get(field);
        if (value == null && !containsKey(field)) {
            System.out.println("Query unknown field " + field);
        }
        return value;
    }

    public static void main(String [] args) throws IOException {
        final TypeReference<FieldsMap<String, Object>> mapType = new TypeReference<FieldsMap<String, Object>>() {};
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule().addAbstractTypeMapping(Map.class, FieldsMap.class);
        objectMapper.registerModule(module);
        Map<String, Object> res = objectMapper.readValue("{\"a\": {\"b\": 0}}", mapType);
        res.get("c");
        System.out.println(res.get("a").getClass().getName());
        ((Map)res.get("a")).get("c");
    }
}