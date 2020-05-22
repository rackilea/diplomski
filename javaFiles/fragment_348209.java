import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.tuple.MutablePair;

import java.io.IOException;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        MutablePair<String, String> pair = new MutablePair<>();
        pair.setLeft("leftV");
        pair.setRight("rightV");

        SimpleModule pairModule = new SimpleModule();
        pairModule.addSerializer(MutablePair.class, new MutablePairJsonSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(pairModule);

        String json = mapper.writeValueAsString(pair);
        System.out.println(json);
        System.out.println(mapper.readValue(json, MutablePair.class));
    }
}