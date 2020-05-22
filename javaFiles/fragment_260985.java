public interface Lookup {
}

public class MapLookup implements Lookup {
    public String getValue(String key) {
        //...
    }
}

public class GuavaLookup implements Lookup {
    public String getValue(String row, String column) {
        // ...
    }
}