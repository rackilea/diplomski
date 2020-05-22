import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hubspot.jackson.datatype.protobuf.ProtobufModule;

import java.io.IOException;

public class ProtobufApp {
    public static void main(String[] args) throws Exception {
        SimpleModule pojosModule = new SimpleModule();
        pojosModule.addDeserializer(Example.class, new ExampleJsonDeserializer());

        ObjectMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addModule(new ProtobufModule())
                .addModule(pojosModule)
                .build();

        String json = "{\"json_id\":\"3\",\"json_another_id\":\"43\",\"code\":34,\"json_name\":\"Yeyproto\"}";
        Example deserialised = mapper.readValue(json, Example.class);
        System.out.println(deserialised);
    }
}

class ExampleJsonDeserializer extends JsonDeserializer<Example> {
    @Override
    public Example deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectNode root = p.readValueAsTree();
        return Example.newBuilder()
                .setId(root.get("json_id").asText())
                .setAnotherId(root.get("json_another_id").asText())
                .setName(root.get("json_name").asText())
                .setCode(root.get("json_id").asInt())
                .build();
    }
}