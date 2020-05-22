public class MainController implements Initializable{

    @FXML Label label_status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            /**Some Code Here...**/
    }

    /**Subscribe Eventbus function**/
    @Subscribe
    public void changeLabelStatus(String status) {
        Platform.runLater(() -> label_status.setText(status));
    }
}