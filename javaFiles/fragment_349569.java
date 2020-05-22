public class MyClass {

    List<FieldListener> listeners = new ArrayList<FieldListener>(); // the placeholder for listeners

    private String field1;
    private String field2;

    /**
     * @param field1 the field1 to set
     */
    public void setField1(String field1) {
        fireEvent("field1", field1);
        this.field1 = field1;
    }
    /**
     * @param field2 the field2 to set
     */
    public void setField2(String field2) {
        fireEvent("field2", field2);
        this.field2 = field2;
    }

    public void addListener(FieldListener l) {
        if(l != null) listeners.add(l);
    }

    public void fireEvent(String fieldName, Object newValue) {
        for(FieldListener l : listeners) {
            l.fieldValueChanged(fieldName, newValue);
        }
    }

    public static void main(String [] args) {
        MyClass m = new MyClass();
        m.addListener(new SampleObserver());
        m.setField1("s");
        m.setField2("v");
    }

}