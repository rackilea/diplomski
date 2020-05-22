import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ComboBoxTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> items = FXCollections.observableArrayList("Item-1", "Item-2", "Item-3");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(items);
        comboBox.getSelectionModel().select(0);

        StackPane root = new StackPane();
        root.getChildren().add(comboBox);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline1 = new Timeline(new KeyFrame(
        Duration.millis(1000), ae -> {
            items.set(0, "Changing the string");
        }));
        timeline1.play();

        primaryStage.setScene(new Scene(new StackPane(comboBox), 300, 100));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}