public class CustomCellDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(getTable());
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }

    private TableView<Person> getTable() {
        TableView<Person> table = new TableView<>();
        table.getColumns().add(statusColumn());
        table.setItems(getItems());
        return table;
    }

    private TableColumn<Person, String> statusColumn() {
        TableColumn<Person, String> status = new TableColumn<>();
        status.setCellFactory(col -> new CircleCell());
        status.setGraphic(new Label("Status"));
        status.setStyle("-fx-alignment:center");
        status.setCellValueFactory(new PropertyValueFactory("Status"));
        status.setMinWidth(199);
        return status;
    }

    private ObservableList<Person> getItems() {
        ObservableList<Person> detail = FXCollections.observableArrayList();
        detail.add(new Person("Medium"));
        detail.add(new Person("Low"));
        detail.add(new Person("High"));
        detail.add(new Person(""));
        detail.add(new Person(null));
        return detail;
    }

    public class Person {
        private SimpleStringProperty status;

        public Person(String status) {
            this.status = new SimpleStringProperty(status);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status = new SimpleStringProperty(status);
        }
    }
}