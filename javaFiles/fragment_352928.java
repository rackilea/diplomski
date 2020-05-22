public class AddItemPresenter {

    @Inject
    private Model model ;

    @FXML
    private TextField textField ;

    // handler for button press:
    @FXML
    private void handleButton() {
        model.getItemList().add(textField.getText());
    }
}