public abstract class AbstractDataModel implements DataModel {

    private List<ChangeListener> changeListeners;
    private int data;

    public AbstractDataModel(int value) {
        this.data = value;
        changeListeners = new ArrayList<>(25);
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        changeListeners.add(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        changeListeners.remove(listener);
    }

    protected void fireStateChanged() {
        if (!changeListeners.isEmpty()) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : changeListeners) {
                listener.stateChanged(evt);
            }
        }
    }

    public void add(int delta) {
        data += delta;
        fireStateChanged();
    }

    @Override
    public int getData() {
        return data;
    }
}

public class DeltaDataModel extends AbstractDataModel {

    private int delta;

    public DeltaDataModel(int value, int delta) {
        super(value);
        this.delta = delta;
    }

    @Override
    public void add() {
        add(delta);
    }

}

public class AddByOneDataModel extends DeltaDataModel {

    public AddByOneDataModel(int value) {
        super(value, 1);
    }
}