public class WindowMainController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(button.getScene()); // Gives you the Scene
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(button.getScene()); // Prints null
    }

}