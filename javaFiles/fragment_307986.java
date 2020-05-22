public class SpecialMap extends HashMap<String, Object>
    implements Comparable<SpecialMap> {

    private final String key;

    public SpecialMap(String key) {
        this.key = key;
    }

    public int compareTo(SpecialMap other) {
        // TODO: Null handling
        Date thisDate = (Date) this.get(key);
        Date otherDate = (Date) other.get(key);
        return thisDate.compareTo(otherDate);
    }
}