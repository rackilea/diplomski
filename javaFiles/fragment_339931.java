import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        Button button = new Button();
        button.textProperty().bind(
            Bindings.when(button.hoverProperty())
                    .then("Hovered")
                    .otherwise("Not Hovered"));
        pane.getChildren().addAll(button);
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}