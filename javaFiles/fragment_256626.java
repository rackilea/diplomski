import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;

public class JsonBooleanApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addHandler(new DeserializationProblemHandler() {
                    @Override
                    public Object handleWeirdStringValue(DeserializationContext ctxt, Class<?> targetType, String valueToConvert, String failureMsg) throws IOException {
                        if (targetType == Boolean.class) {
                            return Boolean.TRUE.toString().equalsIgnoreCase(valueToConvert);
                        }
                        return super.handleWeirdStringValue(ctxt, targetType, valueToConvert, failureMsg);
                    }
                })
                .build();

        System.out.println(mapper.readValue("{\"value\": \"True\"}", BooleanHolder.class));
        System.out.println(mapper.readValue("{\"value\": \"true\"}", BooleanHolder.class));
        System.out.println(mapper.readValue("{\"value\": \"TRUE\"}", BooleanHolder.class));
    }
}

class BooleanHolder {
    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BooleanHolder{" +
                "value=" + value +
                '}';
    }
}