import java.util.HashMap;

public class CaseInsensitiveMap extends HashMap<String, String> {

    @Override
    public String put(String key, String value) {
       return super.put(key.toLowerCase(), value);
    }

    // not @Override because that would require the key parameter to be of type Object
    public String get(String key) {
       return super.get(key.toLowerCase());
    }
}