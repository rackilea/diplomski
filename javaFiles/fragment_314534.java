public class TestApplication extends Application {

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage primaryStage) throws Exception {
        var table = new TableView<>(FXCollections.observableArrayList(
                new Person("John", "SomeGuyWithAReallyObnoxiouslyLongLastName"),
                new Person("Jane", "Smith")
        ));

        var firstNameCol = new TableColumn<Person, String>("First Name");
        firstNameCol.setCellValueFactory(v -> v.getValue().firstNameProperty());

        var lastNameCol = new TableColumn<Person, String>("Last Name");
        lastNameCol.setCellValueFactory(v -> v.getValue().lastNameProperty());

        table.getColumns().addAll(firstNameCol, lastNameCol);
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        primaryStage.setOnShown(we -> {
            we.consume();
            firstNameCol.setPrefWidth(table.getWidth() / 2.0);
            lastNameCol.setPrefWidth(table.getWidth() / 2.0);
        });

        var root = new StackPane(table);
        root.setPadding(new Insets(30.0));
        var scene = new Scene(root, 560.0, 360.0);
        primaryStage.setScene(scene);
        primaryStage.setTitle("People");
        // primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static class Person {

        private final StringProperty firstName = new SimpleStringProperty(this, "firstName");
        public final void setFirstName(String name) { firstName.set(name); }
        public final String getFirstName() { return firstName.get(); }
        public final StringProperty firstNameProperty() { return firstName; }

        private final StringProperty lastName = new SimpleStringProperty(this, "lastName");
        public final void setLastName(String name) { lastName.set(name); }
        public final String getLastName() { return lastName.get(); }
        public final StringProperty lastNameProperty() { return lastName; }

        public Person(String firstName, String lastName) {
            setFirstName(firstName);
            setLastName(lastName);
        }

    }

}