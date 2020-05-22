import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PetsTable extends Application {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Pets");
        stage.setWidth(200);
        stage.setHeight(200);

        ObservableList<Pet> data = FXCollections.observableArrayList(new Pet("Kitty", "Susan"), 
                new Pet("Ploft", "Jackob"));
        TableView<Pet> table = new TableView<Pet>();

        TableColumn name = new TableColumn("Name");
        name.setMinWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<Pet, String>("name"));

        TableColumn owner = new TableColumn("Owner");
        owner.setMinWidth(100);
        owner.setCellValueFactory(new PropertyValueFactory<Pet, String>("owner"));

        table.setItems(data);
        table.getColumns().addAll(name, owner);

        ((Group) scene.getRoot()).getChildren().addAll(table);

        /**********************************************/
        /********* Setting the css style file *******/
        /**********************************************/
        scene.getStylesheets().add("styles/styles.css");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Pet {

        private final SimpleStringProperty name;
        private final SimpleStringProperty owner;

        private Pet(String name, String owner) {
            this.name = new SimpleStringProperty(name);
            this.owner = new SimpleStringProperty(owner);
        }

        public String getName() {
            return name.get();
        }

        public String getOwner() {
            return owner.get();
        }
    }
}