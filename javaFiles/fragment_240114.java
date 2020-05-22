public class MenuWidget extends VBox implements Initializable {
    @FXML
    StackPane menus;

    public MenuWidget() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/MenuWidget.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(menus.getChildren().size());
    }
}