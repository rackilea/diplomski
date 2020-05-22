import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Build the Alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert Test");
        alert.setHeaderText("This uses a custom icon!");

        // Create the ImageView we want to use for the icon
        ImageView icon = new ImageView("your_icon.png");

        // The standard Alert icon size is 48x48, so let's resize our icon to match
        icon.setFitHeight(48);
        icon.setFitWidth(48);

        // Set our new ImageView as the alert's icon
        alert.getDialogPane().setGraphic(icon);
        alert.show();
    }
}