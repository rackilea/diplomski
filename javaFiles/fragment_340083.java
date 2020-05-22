public class Bar extends PropertyChangeBean {

    private int value = 0;

    public void setValue(int new_value) {
        fireChange("value", value, value = new_value);
    }

    public int getValue() {
        return value;
    }
}