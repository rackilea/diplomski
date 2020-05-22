public class MainController {

    // ...

    public void showConnectionErrorWindow(String fileName) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/ConnectionError.fxml"));
        Parent root = loader.load();
        ConnectionErrorController connectionErrorController = loader.getController();
        connectionErrorController.setMainController(this);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        // etc...
    }

    // ...
}