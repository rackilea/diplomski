import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Foo {

    ObjectMapper mapper = new ObjectMapper();
    mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    ObjectNode node = mapper.getNodeFactory().objectNode();
    node.put("token", "045-245");
    node.put("message", "Helló / // \\ \"WÓRLD\" ");
    System.out.println(mapper.writeValueAsString(node));

}