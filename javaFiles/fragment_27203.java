import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RedMenuButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        final StackPane root = new StackPane();
        final MenuButton menuButton = new MenuButton("Menu");
        menuButton.getItems().addAll(new MenuItem("Item 1"), new MenuItem("Item 2"), new MenuItem("Item 3"));
        root.getChildren().add(menuButton);

        final Scene scene = new Scene(root, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        menuButton.lookup(".arrow").setStyle("-fx-background-color: red;");
    }

    public static void main(String[] args) {
        launch(args);
    }
}