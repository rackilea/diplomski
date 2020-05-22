import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Serializer {
    static public Map<String, Object> object2Map(Object o)
    {
        Class co = o.getClass();
        Field [] cfields = co.getDeclaredFields();
        Map<String, Object> ret = new HashMap<>();
        for(Field f: cfields)
        {
            String attributeName = f.getName();
            String getterMethodName = "get"
                               + attributeName.substring(0, 1).toUpperCase()
                               + attributeName.substring(1, attributeName.length());
            Method m = null;
            try {
                m = co.getMethod(getterMethodName);
                Object valObject = m.invoke(o);
                ret.put(attributeName, valObject);
            } catch (Exception e) {
                continue; 
            }
        }
        return ret;
    }
}