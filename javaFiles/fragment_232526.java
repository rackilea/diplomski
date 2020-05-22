public abstract class AbstractDataModel implements DataModel {

    private int data;

    public AbstractDataModel(int value) {
        this.data = value;
    }

    public void add(int delta) {
        data += delta;
    }

    @Override
    public int getData() {
        return data;
    }
}