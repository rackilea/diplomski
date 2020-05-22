public class ButtonTableCell<S,T> extends TableCell<S,T> {

    private Button button;

    public ButtonTableCell(final Callback<Integer, Void> pressedCallback) {
        this(pressedCallback, null, null);
    }

    public ButtonTableCell(final Callback<Integer, Void> pressedCallback, String buttonText, Node buttonGraphic) {
        this.button = new Button(buttonText, buttonGraphic);
        this.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pressedCallback.call(getTableRow().getIndex());
            }
        });
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if(empty) {
            setGraphic(null);
        } else {
            setGraphic(button);
            button.disableProperty().bind(Bindings.not(
                    getTableView().editableProperty().and(
                    getTableColumn().editableProperty()).and(
                    editableProperty())
                ));
        }
    }
}