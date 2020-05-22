import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        Msg msg = new Msg();
        msg.setCode(42);
        msg.setData("Are you suggesting coconuts migrate?");

        System.out.println(convert(msg, "test"));
        System.out.println(convert(msg, "toto"));
        System.out.println(convert(msg, "groovy"));
    }

    public static String convert(Msg msg, String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new ReplaceNamingStrategy(Collections.singletonMap("data", name)));
        return mapper.writeValueAsString(msg);
    }
}