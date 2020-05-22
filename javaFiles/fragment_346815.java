import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Comparator extends Application {

    @Override
      public void start(Stage stage) {
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group(), 450, 250);

        ComboBox<String> emailComboBox = new ComboBox<>();
        emailComboBox.getItems().addAll("A","B","C","D","E");

        emailComboBox.setEditable(true);        

        emailComboBox.getEditor().textProperty().addListener((obs, oldText, newText) -> {
            emailComboBox.setValue(newText);
        });


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        Label to = new Label("To: ");
        Label selected = new Label();
        grid.add(to, 0, 0);
        grid.add(emailComboBox, 1, 0);
        grid.add(selected, 2, 0);

        selected.textProperty().bind(emailComboBox.valueProperty());

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
      }

    public static void main(String[] args) {
        launch(args);
    }
}