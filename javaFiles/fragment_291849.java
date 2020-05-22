public class CANESTreeTableCell extends TreeTableCell<dbBase, object> {

    private final Button button;
    private final TextField textField;
    private final CheckBox checkBox;

    private ObservableValue<object> observable;

    public CustomTreeTableCell() {
        this.button = new Button();
        this.textField = new TextField();
        this.checkBox = new CheckBox();
    }

    @Override
    public void updateItem(object item, boolean empty) {
        super.updateItem(item, empty);

        if(empty) {
            setGraphic(null);
        } else {

            final TreeTableColumn<dbBase, object> column = getTableColumn();
            observable = column==null ? null : 
                column.getCellObservableValue(getIndex());

            if(item instanceof dbType1) {
                if(observable != null) {
                    button.textProperty().bind(
                        observable.getValue().getNameProperty());
                } else if (item!=null) {
                    button.setText(item.getName());
                }
                setGraphic(button);
            } else if (item instanceof dbType2) {
                if(checkBox != null) {
                    checkBox.textProperty().bind(
                        observable.getValue().getNameProperty());
                } else if (item!=null) {
                    checkBox.setText(item.getName());
                }
                setGraphic(checkBox);
            } else if (item instanceof dbType3) {
                if(observable != null) {
                    textField.textProperty().bind(
                        observable.getValue().getNameProperty());
                } else if (item!=null) {
                    textField.setText(item.getName());
                }
                setGraphic(textField);
            } else {
                setGraphic(null);
            } 

        }
    }
}