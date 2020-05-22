import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click me!");
        button.setOnAction(event -> {
            event.consume();
            System.out.println("Button clicked!");
        });

        installAnimation(button);

        primaryStage.setScene(new Scene(new StackPane(button), 300.0, 150.0));
        primaryStage.setTitle("Animation Example");
        primaryStage.show();
    }

    private void installAnimation(Button button) {
        FadeTransition transition = new FadeTransition(Duration.millis(250.0), button);
        transition.setFromValue(0.2);
        transition.setToValue(1.0);

        button.hoverProperty().addListener((obs, wasHover, isHover) -> {
            transition.setRate(isHover ? 1.0 : -1.0);
            transition.play();
        });
        button.setOpacity(transition.getFromValue());
    }

}