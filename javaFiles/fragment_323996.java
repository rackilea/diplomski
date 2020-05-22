public class TableController {

    @FXML 
    private TableView<InputObject> tableInfo;
    @FXML 
    private TableColumn<InputObject, String> col1;

    public void initialize() {
        col1.setCellValueFactory(new PropertyValueFactory<>("text"));
    }

    public void setTableItems(ObservableList<InputObject> tableItems) {
        tableInfo.setItems(tableItems);
    }
}