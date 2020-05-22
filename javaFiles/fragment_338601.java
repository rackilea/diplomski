@XmlRootElement
public class MyHashMapObject<T, U> {
    private Map<T, U> mapProperty;

    public MyHashMapObject() {
        mapProperty = new HashMap<T, U>();
    }

    @XmlJavaTypeAdapter(MapAdapter.class) // NOTE: Our custom XmlAdaper
    public Map<T, U> getMapProperty() {
        return mapProperty;
    }

    public void setMapProperty(Map<T, U> map) {
        this.mapProperty = map;
    }
}