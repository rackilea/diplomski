import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ImageDeserializer extends JsonDeserializer<Image> {

    @Override
    public Image deserialize(final JsonParser parser, final DeserializationContext context)
            throws IOException, JsonProcessingException {
        final JsonToken type = parser.currentToken();
        switch (type) {
            case VALUE_NULL:
                return null;
            case VALUE_STRING:
                return null; // TODO: Should check whether it is empty
            case START_OBJECT:
                return context.readValue(parser, Image.class);
            default:
                throw new IllegalArgumentException("Unsupported JsonToken type: " + type);
        }
    }

}