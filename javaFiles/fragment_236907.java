import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
public static void main(String[] args) throws IOException {
    String json = "{\n" +
            "  \"data\": \"mydata\",\n" +
            "  \"information\": [\n" +
            "    {\n" +
            "      \"info\": \"mnkjshdflkj\",\n" +
            "      \"stuff\": \"things\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"info\": \"khsjfdaksdfh\",\n" +
            "      \"stuff\": \"more things\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    ObjectMapper mapper = new ObjectMapper();
    MyData data = mapper.readValue(json, MyData.class);
    System.out.println(data);
}

public static class MyData {
    String data;
    @JsonDeserialize(using = CustomDeserializer.class)
    Map<String, Info> information;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Info> getInformation() {
        return information;
    }

    public void setInformation(Map<String, Info> information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "data='" + data + '\'' +
                ", information=" + information +
                '}';
    }
}

public static class Info {
    String info; // is it required?
    String stuff;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "Info{" +
                "info='" + info + '\'' +
                ", stuff='" + stuff + '\'' +
                '}';
    }
}

public static class CustomDeserializer extends JsonDeserializer<Map<String, Info>> {
    @Override
    public Map<String, Info> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        List<Info> raw = jp.readValueAs(new TypeReference<List<Info>>() {
        });
        Map<String, Info> result = new HashMap<>();
        for (Info info : raw) {
            result.put(info.getInfo(), info);
        }

        return result;
    }
   }
 }