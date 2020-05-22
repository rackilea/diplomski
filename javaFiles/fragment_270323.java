import java.util.Map;
import java.util.TreeMap;

public class Place {
    //  Static Attributes
    private static final Map<Place, Object> places = new TreeMap<>();

    //  Constructors
    public Place(final Object key, final Place value) {
        places.put(key, value);
    }

    //  Methods - Static Getters
    public static Map<Place, Object> getPlaces() { return places; }
}