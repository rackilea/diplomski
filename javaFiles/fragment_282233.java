public class LoginDialogController {

    @FXML
    private Button button ;

    @FXML
    private void handleButtonPress() {
        button.getScene().getWindow().hide();
    }

    // ...
}