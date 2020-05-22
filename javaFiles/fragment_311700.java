public class Controller implements Initializable {
    @FXML
    AnchorPane anchorPaneLeft;

    public Controller() {
        System.out.println(anchorPaneLeft); //null
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(anchorPaneLeft); //AnchorPane
    }
}