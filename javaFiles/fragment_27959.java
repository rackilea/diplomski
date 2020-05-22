import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonHash {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonStringA = "{\"a\": \"100\", \"b\": \"200\", \"c\": [{\"d\": 200, \"e\": 100}], \"p\": null}";
        String jsonStringB = "{\"p\": null, \"b\": \"200\", \"a\": \"100\", \"c\": [{\"e\": 100, \"d\": 200}]}";
        String jsonStringC = "{\"p\": 1, \"b\": \"200\", \"a\": \"100\", \"c\": [{\"e\": 100, \"d\": 200}]}";

        String hashA = getHash(mapper, jsonStringA);
        String hashB = getHash(mapper, jsonStringB);
        String hashC = getHash(mapper, jsonStringC);

        System.out.println(hashA);
        System.out.println(hashB);
        System.out.println(hashC);
    }

    private static String getHash(ObjectMapper mapper, String jsonStringA) throws IOException {
        JsonNode jsonNode = mapper.readTree(jsonStringA);
        Map map = mapper.convertValue(jsonNode, Map.class);
        TreeMap sorted = sort(map);
        String s = mapper.writeValueAsString(sorted);
        byte[] md5Digest = DigestUtils.md5Digest(s.getBytes());
        return DatatypeConverter.printHexBinary(md5Digest).toUpperCase();
    }

    private static TreeMap sort(Map map) {
        TreeMap result = new TreeMap();
        map.forEach((k, v) -> {
            if(v != null) {
                if (v instanceof Map) {
                    result.put(k, sort((Map) v));
                } else if (v instanceof List) {
                    result.put(k, copyArray((List) v));
                } else {
                    result.put(k, v);
                }
            } else {
               result.put(k, null);
            }
        });
        return result;
    }

    private static List copyArray(List v) {
        List result = new ArrayList(v.size());

        for (int i = 0; i < v.size(); i++) {
            Object element = v.get(i);

            if(element != null) {
                if (element instanceof Map) {
                    result.add(sort((Map) element));
                } else if (element instanceof List) {
                    result.add(copyArray((List) element));
                } else {
                    result.add(element);
                }
            } else {
                result.add(null);
            }
        }

        return result;
    }
}