public class AddByOneDataModel extends AbstractDataModel {

    public AddByOneDataModel(int value) {
        super(value);
    }

    @Override
    public void add() {
        add(1);
    }
}