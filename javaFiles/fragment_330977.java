import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuStyleTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        Menu themes = new Menu("Themes", null, new MenuItem("Light"), new MenuItem("Dark"),
                new MenuItem("Cherry Blossom"));
        MenuBar menuBar = new MenuBar(new Menu("File"), themes, new Menu("Help"));

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}