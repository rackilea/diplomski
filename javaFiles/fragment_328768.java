public class LoginScreen extends ScreenController {

    @FXML private AnchorPane loginWindow;
    @FXML private Button goButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        setWindow(loginWindow); // set window in initialize method
    }

    @FXML
    public void goButtonPressed(ActionEvent event) throws IOException {
        setScreen("Home");
        System.out.println("Success.");
    }

}