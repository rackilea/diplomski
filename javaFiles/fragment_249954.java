import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        DynamicJsonsFactory factory = new DynamicJsonsFactory();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(factory.createUser("Vika")));
        System.out.println(mapper.writeValueAsString(factory.createPhone("123-456-78-9")));
        System.out.println(mapper.writeValueAsString(factory.any("val", "VAL!")));
    }
}

class Value {

    private Map<String, String> values;

    @JsonAnySetter
    public void put(String key, String value) {
        values = Collections.singletonMap(key, value);
    }

    @JsonAnyGetter
    public Map<String, String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}

class DynamicJsonsFactory {

    public Value createUser(String name) {
        return any("name", name);
    }

    public Value createPhone(String number) {
        return any("phone", number);
    }

    public Value any(String key, String value) {
        Value v = new Value();
        v.put(Objects.requireNonNull(key), Objects.requireNonNull(value));

        return v;
    }
}