import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import jackson.Outer.Foo;

public class FooDeserializer extends StdDeserializer<Outer.Foo> implements ResolvableDeserializer {

    private static final long serialVersionUID = 1L;
    private final JsonDeserializer<?> defaultDeserializer;

    public FooDeserializer(JsonDeserializer<?> defaultDeserializer, Class<?> clazz) {
        super(clazz);
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override
    public Outer.Foo deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
            JsonNode node = parser.getCodec().readTree(parser);
            if (node.isTextual()) {
                return new Foo(node.asText(), null);
            }
        }

        return (Foo) defaultDeserializer.deserialize(parser, context);
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
    }

}