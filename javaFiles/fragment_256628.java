import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.BooleanDeserializerIgnoreCase;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonBooleanApp {

    public static void main(String[] args) throws Exception {
        SimpleModule booleanIgnoreCaseModule = new SimpleModule();
        booleanIgnoreCaseModule.addDeserializer(Boolean.class, BooleanDeserializerIgnoreCase.wrapperInstance);
        booleanIgnoreCaseModule.addDeserializer(boolean.class, BooleanDeserializerIgnoreCase.primitiveInstance);

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(booleanIgnoreCaseModule)
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES)
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