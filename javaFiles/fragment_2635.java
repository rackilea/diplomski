import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Object response = new CardResponseBuilder()
                .textParagraph("bla bla")
                .textButton("reminder in 10", "some Method")
                .build();
        System.out.println(mapper.writeValueAsString(response));
    }
}