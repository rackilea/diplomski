import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Collections;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer0 = mapper.writer();
        ObjectWriter writer1 = writer0.with(SerializationFeature.INDENT_OUTPUT);
        ObjectWriter writer2 = writer1.with(SerializationFeature.INDENT_OUTPUT);
        ObjectWriter writer3 = writer2.with(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);

        Map<String, Long> map = Collections.singletonMap("key", 123L);
        System.out.println(writer0 + " = " + writer0.writeValueAsString(map));
        System.out.println(writer1 + " = " + writer1.writeValueAsString(map));
        System.out.println(writer2 + " = " + writer2.writeValueAsString(map));
        System.out.println(writer3 + " = " + writer3.writeValueAsString(map));


        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.enable(SerializationFeature.INDENT_OUTPUT);
        mapper1.enable(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);

        ObjectWriter writer4 = mapper1.writer();
        System.out.println(writer4 + " = " + writer4.writeValueAsString(map));
    }
}