public class Entry {
    private final String id;
    private final String value;
    public Entry(String id, String value) {
        this.id = id; this.value = value;
    }
    public String getId() { return id; }
    public String getValue() { return value; }
    // also implement equals() and hashCode(), please
}

List<Entry> entries = new ArrayList<Entry>();
entries.add(new Entry("rId11","image3"));