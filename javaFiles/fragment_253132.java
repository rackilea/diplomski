import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Test;

public class FlattenJson {
  String json = "{\n" +
      "   \"Port\":\n" +
      "   {\n" +
      "       \"@alias\": \"defaultHttp\",\n" +
      "       \"Enabled\": \"true\",\n" +
      "       \"Number\": \"10092\",\n" +
      "       \"Protocol\": \"http\",\n" +
      "       \"KeepAliveTimeout\": \"20000\",\n" +
      "       \"ThreadPool\":\n" +
      "       {\n" +
      "           \"@enabled\": \"false\",\n" +
      "           \"Max\": \"150\",\n" +
      "           \"ThreadPriority\": \"5\"\n" +
      "       },\n" +
      "       \"ExtendedProperties\":\n" +
      "       {\n" +
      "           \"Property\":\n" +
      "           [                         \n" +
      "               {\n" +
      "                   \"@name\": \"connectionTimeout\",\n" +
      "                   \"$\": \"20000\"\n" +
      "               }\n" +
      "           ]\n" +
      "       }\n" +
      "   }\n" +
      "}";

  @Test
  public void testCreatingKeyValues() {
    Map<String, String> map = new HashMap<String, String>();
    try {
      addKeys("", new ObjectMapper().readTree(json), map);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(map);
  }

  private void addKeys(String currentPath, JsonNode jsonNode, Map<String, String> map) {
    if (jsonNode.isObject()) {
      ObjectNode objectNode = (ObjectNode) jsonNode;
      Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
      String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

      while (iter.hasNext()) {
        Map.Entry<String, JsonNode> entry = iter.next();
        addKeys(pathPrefix + entry.getKey(), entry.getValue(), map);
      }
    } else if (jsonNode.isArray()) {
      ArrayNode arrayNode = (ArrayNode) jsonNode;
      for (int i = 0; i < arrayNode.size(); i++) {
        addKeys(currentPath + "[" + i + "]", arrayNode.get(i), map);
      }
    } else if (jsonNode.isValueNode()) {
      ValueNode valueNode = (ValueNode) jsonNode;
      map.put(currentPath, valueNode.asText());
    }
  }
}