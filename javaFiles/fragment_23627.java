import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RadioButtonListView extends Application {

    public static final ObservableList names =
            FXCollections.observableArrayList();
    private ToggleGroup group = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List View Sample");

        final ListView listView = new ListView();
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        names.addAll(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        );

        listView.setItems(names);
        listView.setCellFactory(param -> new RadioListCell());

        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class RadioListCell extends ListCell<String> {
        @Override
        public void updateItem(String obj, boolean empty) {
            super.updateItem(obj, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                RadioButton radioButton = new RadioButton(obj);
                radioButton.setToggleGroup(group);
                // Add Listeners if any
                setGraphic(radioButton);
            }
        }
    }
}