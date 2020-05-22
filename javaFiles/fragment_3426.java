import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DtoDeserializer extends JsonDeserializer<Dto> {

    @Override
    public Dto deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Dto dto = new Dto();
        dto.configs = new ArrayList<Config>();
        while (parser.nextToken() == JsonToken.FIELD_NAME) {
            deserializeType(parser, dto);
            deserializeConfigs(parser, dto);
        }
        return dto;
    }

    private void deserializeType(JsonParser parser, Dto dto) throws IOException, JsonProcessingException {
        if (!"type".equals(parser.getCurrentName())) {
            return;
        }
        parser.nextToken();
        dto.type = parser.getValueAsString();
    }

    private void deserializeConfigs(JsonParser parser, Dto dto) throws IOException, JsonProcessingException {
        if (!"configs".equals(parser.getCurrentName())) {
            return;
        }
        if (parser.nextToken() != JsonToken.START_ARRAY) {
            return;
        }
        while (parser.nextValue() != null) {
            if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
                continue;
            }
            Config config = new Config();
            config.powers = new ArrayList<Power>();
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                if ("itemLevel".equals(parser.getCurrentName())) {
                    parser.nextToken();
                    config.itemLevel = parser.getValueAsInt();
                } else if ("power".equals(parser.getCurrentName())) {
                    parser.nextToken();
                    config.powers.add(parser.readValueAs(getPowerClass(dto.type)));
                }
            }
            dto.configs.add(config);
        }
    }

    private Class<? extends Power> getPowerClass(String type) {
        if ("first_type".equals(type)) {
            return FirstPower.class;
        } else if ("second_type".equals(type)) {
            return SecondPower.class;
        }
        throw new IllegalArgumentException("Not known type" + type);
    }
}