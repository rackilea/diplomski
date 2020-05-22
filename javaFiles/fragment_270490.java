import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SpinnerTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Spinner<Integer> spinner = new Spinner<>(1, 3, 1);
        Scene scene = new Scene(new StackPane(spinner), 180, 80);

        spinner.applyCss();
        spinner.lookup(".increment-arrow-button").addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if (spinner.getValue().intValue() == 3) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Maximum is 3");
                alert.showAndWait();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}