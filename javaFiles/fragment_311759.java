public class EnumSpinnerListener<T extends Enum<T>> // note the correction here
implements AdapterView.OnItemSelectedListener {

    private final Class<T> type;

    private String mValue = null;

    public EnumSpinnerListener(Class<T> type, AdapterView<?> adapterView) {
        this.type = type;
        adapterView.setOnItemSelectedListener(this);
    }

    public T getValue() {
        return Enum.valueOf(type, mValue);
    }
}