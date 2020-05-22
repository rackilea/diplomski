public class ControllerList {

    @FXML ListView<ColoredText> listView;
    @FXML Button btnSend;
    @FXML ColorPicker colorPicker;
    @FXML TextField textField;

    public void initialize() {
        listView.setCellFactory(lv -> new ListCell<ColoredText>() {
            @Override
            protected void updateItem(ColoredText item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                    setTextFill(null);
                } else {
                    setText(item.getText());
                    setTextFill(item.getColor());
                }
            }
        });
    }

    public void clickSend() {
        listView.getItems().add(new ColoredText(textField.getText(), colorPicker.getValue()));
    }

}