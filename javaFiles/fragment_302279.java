import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class MyClass<V extends Class<V>> {

    public MyClass(Properties prop, V type){
        Map<String,V> myMap = new HashMap<String,V>();
    }

}