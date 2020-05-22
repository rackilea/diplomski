import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class JsonApp {

    public static void main(String[] args) throws IOException {
        Node nodeD = new Node("D", null);
        Node nodeC = new Node("C", nodeD);
        Node nodeB = new Node("B", nodeC);
        Node nodeA = new Node("A", nodeB);

        for (int i = 0; i < 4; i++) {
            System.out.println("Depth: " + i);
            System.out.println(serialiseWithDepth(nodeA, i));
        }
    }

    private static ObjectMapper mapper = JsonMapper.builder()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .addModule(createNodeModule())
            .build();

    private static String serialiseWithDepth(Node node, int maxDepth) throws JsonProcessingException {
        ObjectWriter writer = mapper.writerFor(Node.class)
                .withAttribute(NodeDepthBeanSerializer.DEPTH_KEY, new AtomicInteger(maxDepth));

        return writer.writeValueAsString(node);
    }

    private static SimpleModule createNodeModule() {
        SimpleModule nodeModule = new SimpleModule("NodeModule");
        nodeModule.setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                if (beanDesc.getBeanClass() == Node.class) {
                    return new NodeDepthBeanSerializer((BeanSerializerBase) serializer);
                }
                return super.modifySerializer(config, beanDesc, serializer);
            }
        });
        return nodeModule;
    }
}

class NodeDepthBeanSerializer extends BeanSerializer {

    public static final String DEPTH_KEY = "maxDepthSize";

    public NodeDepthBeanSerializer(BeanSerializerBase src) {
        super(src);
    }

    @Override
    protected void serializeFields(Object bean, JsonGenerator gen, SerializerProvider provider) throws IOException {
        AtomicInteger depth = (AtomicInteger) provider.getAttribute(DEPTH_KEY);
        if (depth.decrementAndGet() >= 0) {
            super.serializeFields(bean, gen, provider);
        }
    }
}