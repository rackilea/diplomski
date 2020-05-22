public class StartController extends BaseController {

    @FXML
    private void loadSecondPage(ActionEvent event) throws IOException {
        AnchorPane startPage = 
            FXMLLoader.load(getClass().getResource("SecondController.fxml"));
        getRootPane().getChildren().setAll(startPage);
        makeFadeIn();
    }
}

public class SecondController extends BaseController {

    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {
        AnchorPane startPage = 
            FXMLLoader.load(getClass().getResource("StartController.fxml"));
        getRootPane().getChildren().setAll(startPage);
    }
}