import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuItem menuItem1 = new MenuItem("Option 1");

        // parameters = "prompt" "Icon/Graphics/" "menuItem1"
        MenuButton menuButton = new MenuButton("Options", null, menuItem1);

        menuItem1.setOnAction(e -> {
            menuButton.setText(menuItem1.getText());
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(menuButton);

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}