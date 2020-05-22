public class FormattedMap<T_KEY, T_VALUE> extends LinkedHashMap<T_KEY, ArrayList<T_VALUE>> {

    public FormattedMap() {
        super();
    }

    public void addMapValue(T_KEY key, T_VALUE value) {
    }

    public void removeMapValue(T_KEY key, T_VALUE value) {
    }

    public static void main(String [] args) {
        FormattedMap<String, Integer> fm = new FormattedMap<>(); // This is fine
        fm.addMapValue("first", new Integer(2));
        // this is valid, because fm is of type FormattedMap<String, Integer>
    }
}