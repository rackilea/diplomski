public class Controller {

    @FXML
    private TableView<Model> tableBuilding;
    @FXML
    private TableColumn<Model, Boolean> colActive;
    @FXML
    private TableColumn<Model, Model> colAction;

    @FXML
    public void initialize() {

        // Sample List
        ObservableList<Model> models = FXCollections.observableArrayList();
        models.addAll(
                new Model(),
                new Model(),
                new Model()
        );

        tableBuilding.setItems(models);

        //Containing the button
        colAction.setCellFactory(col -> {
            Button ShowButton = new Button("Show");

            TableCell<Model, Model> cell = new TableCell<>() {
                @Override
                //Updating with the number of row
                public void updateItem(Model building, boolean empty) {
                    super.updateItem(building, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(ShowButton);
                    }
                }
            };

            ShowButton.setOnAction(event -> {

                TableRow row = cell.getTableRow();
                Model building = (Model) row.getItem();

                System.out.println(building.getActive());

            });

            return cell;
        });

        //Containing the checkbox
        colActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        colActive.setCellFactory(col -> new CheckBoxTableCell<>());

    }
}