@XmlJavaTypeAdapter(MapAdapter.class)
public class Record extends HashMap<String, String> {
    private static final long serialVersionUID = 1L;

    public Record addElement(String name, String value) {
        put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "Record" + super.toString();
    }
}