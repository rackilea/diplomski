import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewComboBoxCell extends Application {

    private TableView<Person> table = new TableView<Person>();

    private final ObservableList<Person> data = FXCollections
            .observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson",
                            "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams",
                            "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com"));


    public static void main(String[] args) {
        launch(args);
    }

    private final ObservableList<String> comboList = FXCollections.observableArrayList("First big sentence with very long text to check the text wrap",
            "Second big sentence with very long text to check the text wrap",
            "Third big sentence with very long text to check the text wrap",
            "Fourth big sentence with very long text to check the text wrap");

    @Override
    public void start(Stage stage) {
        for (int i = 0; i < 50; i++) {
            if(i%5==0){
                data.add(new Person("Name " + i, "Last " + i, "Mail " + i, comboList.get(0)));
            }else {
                data.add(new Person("Name " + i, "Last " + i, "Mail " + i));
            }
        }
        Scene scene = new Scene(new StackPane());
        stage.setTitle("Table View Sample");
        stage.setWidth(650);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol
                .setCellValueFactory(new PropertyValueFactory<Person, String>(
                        "firstName"));

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol
                .setCellValueFactory(new PropertyValueFactory<Person, String>(
                        "lastName"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
                "email"));

        TableColumn<Person, String> comboCol = new TableColumn<>("Combo");
        comboCol.setMinWidth(200);
        comboCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
                "combo"));
        comboCol.setCellFactory(new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
            @Override
            public TableCell<Person, String> call(TableColumn<Person, String> param) {
                return new TableCell<Person, String>() {
                    private ComboBox<String> combo;

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        getCombo().getSelectionModel().clearSelection();
                        if (!empty) {
                            getCombo().setValue(item);
                            setGraphic(getCombo());
                        } else {
                            setGraphic(null);
                        }
                    }

                    private ComboBox<String> getCombo() {
                        if (combo == null) {
                            combo = new ComboBox<>();
                            combo.setItems(comboList);
                            combo.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
                                ((Person) getTableRow().getItem()).setCombo(newVal);
                            });
                            combo.setButtonCell(new ListCell<String>() {
                                private Text textLbl;
                                @Override
                                protected void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    setGraphic(null);
                                    if (!empty) {
                                        getTextLbl().setText(item);
                                        setGraphic(getTextLbl());
                                    }
                                }

                                private Text getTextLbl(){
                                    if(textLbl ==null){
                                        textLbl = new Text();
                                        textLbl.wrappingWidthProperty().bind(this.widthProperty().subtract(10));
                                    }
                                    return textLbl;
                                }
                            });
                        }
                        return combo;
                    }
                };
            }
        });
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, comboCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        ((StackPane) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty combo;

        private Person(String fName, String lName, String email) {
            this(fName,lName,email,null);
        }

        private Person(String fName, String lName, String email, String comboStr) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.combo = new SimpleStringProperty(comboStr);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public SimpleStringProperty firstNameProperty() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }

        public String getEmail() {
            return email.get();
        }

        public SimpleStringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public String getCombo() {
            return combo.get();
        }

        public SimpleStringProperty comboProperty() {
            return combo;
        }

        public void setCombo(String combo) {
            this.combo.set(combo);
        }
    }
}