public class HomeScreen extends ScreenController {

    @FXML private AnchorPane homeWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        setWindow(homeWindow); // set window in initialize method
    }

}