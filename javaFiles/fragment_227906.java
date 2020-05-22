public class FormattedMap<T_KEY, T_VALUE> extends LinkedHashMap<T_KEY, ArrayList<T_VALUE>> {

    private T_KEY mapKey;
    private T_VALUE mapValue;
    public boolean DEBUG=false;

    public FormattedMap() {
        super();
    }

    public void addMapValue(T_KEY key, T_VALUE value) {
    }

    public void removeMapValue(T_KEY key, T_VALUE value) {
    }

    public void test(boolean b) {
        addMapValue("first", new Integer(2)); // This triggers the compilor error message
    }
}