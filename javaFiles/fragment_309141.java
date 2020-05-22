import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;
import java.util.UUID;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        SimpleModule wrappersModule = new SimpleModule("requestWrapper");
        wrappersModule.setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                if (Request.class.isAssignableFrom(beanDesc.getBeanClass())) {
                    return new RequestWrapperJsonSerializer(serializer);
                }
                return serializer;
            }
        });
        ObjectMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addModule(wrappersModule)
                .build();

        System.out.println(mapper.writeValueAsString(new Request1(1, "POST")));
        System.out.println(mapper.writeValueAsString(new Request2(2, UUID.randomUUID())));
    }
}

class RequestWrapperJsonSerializer extends JsonSerializer<Request> {

    private final JsonSerializer baseSerializer;

    public RequestWrapperJsonSerializer(JsonSerializer baseSerializer) {
        this.baseSerializer = baseSerializer;
    }

    @Override
    public void serialize(Request value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName(value.getClass().getSimpleName() + "Wrapper");
        gen.writeStartObject();
        baseSerializer.unwrappingSerializer(NameTransformer.NOP).serialize(value, gen, serializers);
        gen.writeEndObject();
        gen.writeEndObject();
    }
}

abstract class Request {
    private int id;

    //constructor, getters, setters, toString
}

class Request1 extends Request {
    private String body;

    //constructor, getters, setters, toString
}

class Request2 extends Request {

    private UUID uuid;

    //constructor, getters, setters, toString
}