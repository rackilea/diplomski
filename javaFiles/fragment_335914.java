import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class DelegateDeserializer {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();

        simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc,
                    JsonDeserializer<?> deserializer) {
                if (Outer.Foo.class.isAssignableFrom(beanDesc.getBeanClass())) {
                    return new FooDeserializer(deserializer, beanDesc.getBeanClass());
                }
                return deserializer;
            }
        });

        mapper.registerModule(simpleModule);

        Outer outer1 = mapper.readValue(getType1Json(), Outer.class);
        Outer outer2 = mapper.readValue(getType2Json(), Outer.class);
        System.out.println("deserialize json with object structure:");
        System.out.println(outer1.getFoo().getName());
        System.out.println(outer1.getFoo().getBar());
        System.out.println("deserialize json with string field only:");
        System.out.println(outer2.getFoo().getName());
        System.out.println(outer2.getFoo().getBar());
    }

    private static String getType1Json() {

        return "  {                                                                        "
                + "  \"foo\": {                                                            "
                + "     \"name\": \"John Smith\",                                          "
                + "    \"bar\": \"baz\"                                                    "
                + "   }                                                                    "
                + "}                                                                       ";

    }

    private static String getType2Json() {

        return "  {                                                                        "
                + "  \"foo\": \"John Smith\"                                               "
                + "}                                                                       ";

    }
}