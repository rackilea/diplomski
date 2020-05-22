import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = (ObjectNode) mapper.readTree(jsonFile);
        ArrayNode array = (ArrayNode) root.get("secondArray");

        int numberToRemove = 1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).get("number").asInt() == numberToRemove) {
                array.remove(i);
                break;
            }
        }
        System.out.println(array);
        System.out.println(root);
    }
}