import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class JacksonTest {

    public static class ModelClass {
        private final Map<String, String> map;

        public ModelClass(final Map<String, String> map) {
            super();
            this.map = map;
        }

        @JsonSerialize(using = MyCustomSerializer.class)
        public Map<String, String> getMap() {
            return map;
        }

    }

    public static void main(final String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(System.out, new ModelClass(Collections.singletonMap("test", "test")));
    }

}