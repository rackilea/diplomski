import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowAndWaitNonModalTest extends Application {

    private Stage alertWindow ;

    @Override
    public void start(Stage primaryStage) {
        Button show = new Button("Show");

        alertWindow = new Stage();

        show.setOnAction(e -> {
            Button ok = new Button("OK");
            Scene scene = new Scene(new StackPane(ok), 250, 250);
            alertWindow.setScene(scene);
            ok.setOnAction(evt -> alertWindow.hide());
            alertWindow.showAndWait();
        });

        show.disableProperty().bind(alertWindow.showingProperty());

        Scene scene = new Scene(new StackPane(show), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}