public class ButtonTableCell<S, T> extends TableCell<S, T> {

    private Button button;

    public ButtonTableCell() {
        this.button = new Button("View Info");
        button.setOnAction(event -> {
            Model model = (Model) getTableRow().getItem();
            Dialog<SubModel> dialog = new AmountDialog(model.getSubModel());
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait().ifPresent(result -> {
                model.amountProperty().set(result.getxAmount() + result.getyAmount());
            });
        });
    }

    @Override protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(button);
        }
    }
}