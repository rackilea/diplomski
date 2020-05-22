import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class Sol {
    public static void main(String[] args) {
        String data = "[{\"AnnotationOfzelda\":\n" +
                " [{\"annotation\":\n" +
                "  [{\"duration\":5000,\"annotation\":\"salut\",\"timestamp\":2250.0}, \n" +
                "   {\"duration\":5000,\"annotation\":\"jp\",\"timestamp\":4570.0}]}, \n" +
                "   {\"duration\":5000,\"annotation\":\"asd\",\"timestamp\":3340.0}, \n" +
                "   {\"duration\":5000,\"annotation\":\"asd\",\"timestamp\":4040.0}]}]";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(data);
            Iterator iterator = jsonNode.iterator();
            while (iterator.hasNext()) {
                JsonNode node = (JsonNode) iterator.next();
                if (node.get("annotation") != null) {
                    System.out.println(node.get("annotation"));
                    continue;
                }
                if (node.iterator().hasNext()) {
                    iterator = node.iterator();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}