import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bubble extends Application {
    private static final String SQUARE_BUBBLE =
            "M24 1h-24v16.981h4v5.019l7-5.019h13z";
    // source for svg path string: https://iconmonstr.com/speech-bubble-7/
    private static final String ROUND_BUBBLE =
            "M12 1c-6.628 0-12 4.573-12 10.213 0 2.39.932 4.591 2.427 6.164l-2.427 5.623 7.563-2.26c9.495 2.598 16.437-3.251 16.437-9.527 0-5.64-5.372-10.213-12-10.213z";

    @Override
    public void start(Stage stage) {
        Label label = new Label("hello, world");
        label.setStyle("-fx-font-size: 16px;");

        StackPane bubble = new StackPane(label);
        bubble.setPadding(new Insets(20));
        bubble.setStyle(
            "-fx-background-color: lightblue; " +
            "-fx-border-color: navy; -fx-border-width: 2px; " + 
            "-fx-shape: \"" + ROUND_BUBBLE + "\";"
        );
        bubble.setEffect(new DropShadow(10, 5, 5, Color.MIDNIGHTBLUE));

        StackPane layout = new StackPane(bubble);
        layout.setPadding(new Insets(20));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}