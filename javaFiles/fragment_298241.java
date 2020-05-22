import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.Arrays;
import java.util.List;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        A a = new A();
        a.c = "String";
        a.as = Arrays.asList("1", "2", "tom", "Nick");

        SimpleModule mergeDuplicatesModule = new SimpleModule("Merge duplicated fields in array");
        mergeDuplicatesModule.addDeserializer(JsonNode.class, new MergeDuplicateFieldsJsonNodeDeserializer());

        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(mergeDuplicatesModule);

        String xml = mapper.writeValueAsString(a);

        System.out.println(xml);
        System.out.println(mapper.readTree(xml));
    }
}