import java.util.HashMap;

public class MapContainer {

    public String get(String key) {
        return getMap().get(key);
    }

    private HashMap<String, String> getMap() {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("one", "ONE");
        myMap.put("two", "TWO");
        myMap.put("three", "THREE");
        return myMap;
    }
}