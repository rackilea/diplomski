import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class JsonResolver extends TypeIdResolverBase {

    private static Map<String,Class<?>> ID_TO_TYPE=new HashMap<>();
    static {
        ID_TO_TYPE.put("car",Car.class);
        ID_TO_TYPE.put("truck",Truck.class);
    }
    public JsonResolver() {
        super();
    }

    @Override
    public Id getMechanism() {
        return null;
    }

    @Override
    public String idFromValue(Object value) {
        return value.getClass().getSimpleName();
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> arg1) {
        return idFromValue(value);
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) {
        return context.getTypeFactory().constructType(ID_TO_TYPE.get(id));
    }
}