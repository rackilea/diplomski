import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateTextFieldOnToggle extends Application {

    @Override
    public void start(Stage primaryStage) {
        ToggleButton toggleButton = new ToggleButton("Generate");
        TextField textField = new TextField();

        AtomicBoolean running = new AtomicBoolean();

        toggleButton.setOnAction(event -> {

            running.set(toggleButton.isSelected());

            try {

                if (running.get()) {
                    Thread t = new Thread(new Runnable() {
                        public void run() {
                            while (running.get()) {
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                Platform.runLater(() -> {
                                    double rand = Math.random();
                                    textField.setText(String.format("%f", rand));
                                });
                            }
                        }
                    });
                    t.setDaemon(true);
                    t.start();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
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