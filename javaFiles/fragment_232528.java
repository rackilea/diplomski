public class DeltaDataModel extends AbstractDataModel {

    private int delta;

    public DeltaDataModel(int delta, int value) {
        super(value);
        this.delta = delta;
    }

    @Override
    public void add() {
        add(delta);
    }

}