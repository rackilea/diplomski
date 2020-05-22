public class TableViewWithButtonColumnDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Person> tableview = new TableView<>(
            FXCollections.observableArrayList(
                new Person("Person", "1"),
                new Person("Person", "2"),
                new Person("Person", "3")));

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));

        Button addButton = new Button("+");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableview.getItems().add(new Person("person", String.valueOf(tableview.getItems().size()+1)));
            }
        });

        TableColumn<Person, Object> buttonColumn = new TableColumn<>();
        buttonColumn.setGraphic(addButton);
        buttonColumn.setCellFactory(new Callback<TableColumn<Person,Object>, TableCell<Person,Object>>() {
            @Override
            public TableCell<Person, Object> call(TableColumn<Person, Object> param) {
                Callback<Integer, Void> pressedCallback = new Callback<Integer, Void>() {
                    @Override
                    public Void call(Integer index) {
                        Person buttonPressedPerson = tableview.getItems().get(index);
                        tableview.getItems().remove(buttonPressedPerson);
                        return null;
                    }
                };
                return new ButtonTableCell<>(pressedCallback, "-", null);
            }
        });

        tableview.setEditable(true);
        tableview.getColumns().addAll(firstNameColumn, lastNameColumn, buttonColumn);

        primaryStage.setScene(new Scene(tableview));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}