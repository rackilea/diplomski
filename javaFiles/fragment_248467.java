public class MainController {


    @FXML
    public Label mainLabel;

    @FXML
    public TextField mainTextField;

    @FXML
    public Button mainButton;

    @FXML
    public void onMainButtonClicked() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Alert.fxml"));
        Parent root = loader.load();
        AlertController alertController = loader.getController();
        alertController.setAlertLabel("Hello from MainController!");
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Alert");
        window.show();
    }
}