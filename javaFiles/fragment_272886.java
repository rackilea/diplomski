public class ChildController {

    @FXML
    private Label label ;

    @FXML
    private ComboBox<String> comboBox ;

    // etc...

    public void setDisplayText(String text) {
        label.setText(text);
    }

    public String getUserSelectedValue() {
        return comboBox.getValue();
    }

    // ...
}