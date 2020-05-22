public class Controller implements Initializable {

    @FXML
    private TableView<Model> table;
    @FXML
    private TableColumn<Model, Long> colId;
    @FXML
    private TableColumn<Model, Double> colAmount;
    @FXML
    private TableColumn<Model, SubModel> colInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTable();
        setupData();
    }

    private void setupTable() {
        colId.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        colAmount.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
        colInfo.setCellValueFactory(data -> data.getValue().subModelProperty());

        colInfo.setCellFactory(factory -> new ButtonTableCell<>());
    }

    private void setupData() {
        SubModel firstSubModel = new SubModel(1L, 0D, 0D);
        SubModel secondSubModel = new SubModel(2L, 0D, 0D);

        Model fist = new Model(1L, 0D, firstSubModel);
        Model second = new Model(2L, 0D, secondSubModel);

        ObservableList<Model> tableData = FXCollections.observableArrayList();
        tableData.add(fist);
        tableData.add(second);

        table.setItems(tableData);
    }
}