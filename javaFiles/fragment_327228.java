package io.quicktype;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Stuff.Deserializer.class)
@JsonSerialize(using = Stuff.Serializer.class)
public class Stuff {
    public String stringValue;
    public String[] stringArrayValue;

    static class Deserializer extends JsonDeserializer {
        @Override
        public Stuff deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Stuff value = new Stuff();
            switch (jsonParser.getCurrentToken()) {
            case VALUE_STRING:
                value.stringValue = jsonParser.readValueAs(String.class);
                break;
            case START_ARRAY:
                value.stringArrayValue = jsonParser.readValueAs(String[].class);
                break;
            default: throw new IOException("Cannot deserialize Stuff");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer {
        @Override
        public void serialize(Stuff obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            throw new IOException("Stuff must not be null");
        }
    }
}