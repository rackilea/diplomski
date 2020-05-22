public class TableViewViaInterface extends Application {

    private BorderPane root ;
    private TableView<? extends TableEntry> table ;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        Button showPersonTable = new Button("Person table");
        showPersonTable.setOnAction(e -> showPersonTable());
        Button showAddressTable = new Button("Address table");
        showAddressTable.setOnAction(e -> showAddressTable());

        HBox buttons = new HBox(5, showPersonTable, showAddressTable);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(5));
        root.setBottom(buttons);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showPersonTable() {

        TableView<Person> personTable = new TableView<>();
        personTable.getColumns().clear();
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        personTable.getColumns().add(firstNameCol);

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        personTable.getColumns().add(lastNameCol);

        // populate table...

        this.table = personTable ;
        root.setCenter(personTable);
    }

    private void showAddressTable() {

        TableView<Address> addressTable = new TableView<>();
        addressTable.getColumns().clear();
        TableColumn<Address, String> streetCol = new TableColumn<>("Street");
        streetCol.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        addressTable.getColumns().add(streetCol);

        TableColumn<Address, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        addressTable.getColumns().add(cityCol);

        // populate table...

        this.table = addressTable ;
        root.setCenter(addressTable);

    }

    // interface and classes as above...
}