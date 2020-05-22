import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UpdateTextFieldOnToggle extends Application {

    @Override
    public void start(Stage primaryStage) {
        ToggleButton toggleButton = new ToggleButton("Generate");
        TextField textField = new TextField();

        Timeline changeTextField = new Timeline(
            new KeyFrame(Duration.millis(200), event -> {
                double rand = Math.random();
                textField.setText(String.format("%f", rand));
            })  
        );

        changeTextField.setCycleCount(Animation.INDEFINITE);

        toggleButton.setOnAction(event -> {
            if (toggleButton.isSelected()) {
                changeTextField.play();
            } else {
                changeTextField.stop();
            }
        });

        VBox root = new VBox(10, toggleButton, textField);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(24));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}