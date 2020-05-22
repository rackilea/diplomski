public class MySequence {
    private List<Object> values;

    public void add(Object value) {
        values.add(value);
    }

    public Object[] getValues() {
        return values.toArray(new Object[values.size()]);
    }

    public void setValues(Object[] values) {
        this.values = Arrays.asList(values);
    }
}