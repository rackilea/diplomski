import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.Assert;

import java.io.File;
import java.util.LinkedHashMap;

public class JsonMapApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonParser jsonParser = mapper.getFactory().createParser(jsonFile);
        jsonParser.nextToken();

        MapType mapType = mapper.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, String.class);
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            LinkedHashMap<String, String> map = mapper.readValue(jsonParser, mapType);
            map.forEach((k, v) -> {
                Assert.isInstanceOf(String.class, v);
                System.out.println(k + " -> " + v + " (" + v.getClass().getName() + ")");
            });
        }
    }
}