import java.time.LocalDate;
import java.util.Comparator;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class TableCelDisableButton extends Application {

    private ObservableList<Person> tableData;

    @Override
    public void start(Stage primaryStage) {

        TableView<Person> table = new TableView<>();
        tableData = FXCollections.observableArrayList(p -> new Observable[] {p.dateProperty()});
        table.setItems(tableData);

        ObjectBinding<Person> personWithLatestDate = Bindings.createObjectBinding(() -> 
                tableData.stream().max(Comparator.comparing(Person::getDate)).orElse(null), 
                tableData);

        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Person, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        TableColumn<Person, Person> actionsCol = new TableColumn<>("Actions");
        actionsCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        actionsCol.setCellFactory(tc -> new TableCell<Person, Person>() {
            Button edit = new Button("Edit");
            Button button = new Button("Click");
            HBox buttons = new HBox(5, edit, button);

            {
                edit.setOnAction(e -> edit(getItem(), primaryStage, false));
                button.disableProperty().bind(itemProperty().isNotEqualTo(personWithLatestDate));
            }

            @Override
            protected void updateItem(Person person, boolean empty) {
                super.updateItem(person, empty);
                setGraphic(empty ? null : buttons);
            }
        });

        table.getColumns().add(nameCol);
        table.getColumns().add(dateCol);
        table.getColumns().add(actionsCol);

        table.getItems().add(new Person("Jack", LocalDate.of(2016, 6, 23)));
        table.getItems().add(new Person("Jane", LocalDate.of(2017, 2, 12)));
        table.getItems().add(new Person("Mikel", LocalDate.of(2017, 5, 22)));

        Button add = new Button("Add");
        add.setOnAction(e -> edit(new Person("", LocalDate.now()), primaryStage, true));

        Button delete = new Button("Delete");
        delete.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        delete.setOnAction(e -> tableData.remove(table.getSelectionModel().getSelectedIndex()));

        HBox buttons = new HBox(5, add, delete);
        buttons.setPadding(new Insets(5));
        buttons.setAlignment(Pos.CENTER);


        Scene scene = new Scene(new BorderPane(table, null, null, buttons, null), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void edit(Person person, Window primaryStage, boolean addOnCommit) {
        GridPane editor = new GridPane();
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHgrow(Priority.NEVER);
        leftCol.setHalignment(HPos.RIGHT);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.SOMETIMES);
        rightCol.setHalignment(HPos.LEFT);
        editor.getColumnConstraints().addAll(leftCol, rightCol);

        editor.setHgap(5);
        editor.setVgap(8);
        editor.setPadding(new Insets(10));

        editor.add(new Label("Name:"), 0, 0);
        editor.add(new Label("Date"), 0, 1);
        TextField name = new TextField(person.getName());
        editor.add(name, 1, 0);
        DatePicker date = new DatePicker(person.getDate());
        editor.add(date, 1, 1);

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        HBox buttons = new HBox(5, ok, cancel);
        buttons.setAlignment(Pos.CENTER);
        editor.add(buttons, 0, 2, 2, 1);


        Scene scene = new Scene(editor);
        Stage editDialog = new Stage();
        editDialog.setScene(scene);
        editDialog.initModality(Modality.APPLICATION_MODAL);
        editDialog.initOwner(primaryStage);
        editDialog.initStyle(StageStyle.UNDECORATED);

        editDialog.sizeToScene();

        ok.setOnAction(e -> {
            person.setName(name.getText());
            person.setDate(date.getValue());
            if (addOnCommit) {
                tableData.add(person);
            }
            editDialog.hide();
        });

        cancel.setOnAction(e -> editDialog.hide());

        editDialog.show();
    }

    public static class Person {
        private final StringProperty name = new SimpleStringProperty();
        private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

        public Person(String name, LocalDate date) {
            setName(name);
            setDate(date);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }


        public final java.lang.String getName() {
            return this.nameProperty().get();
        }


        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }


        public final ObjectProperty<LocalDate> dateProperty() {
            return this.date;
        }


        public final java.time.LocalDate getDate() {
            return this.dateProperty().get();
        }


        public final void setDate(final java.time.LocalDate date) {
            this.dateProperty().set(date);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}