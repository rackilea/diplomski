public class Controller implements Initializable {

    @FXML
    private TableController tableController ;

    @FXML
    private InputController inputController ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<InputObject> items = FXCollections.observableArrayList();
        tableController.setTableItems(items);
        inputController.setTableItems(items);
    }
}