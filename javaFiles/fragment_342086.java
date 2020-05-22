import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.stage.Stage;

public class SystemClipboardWatcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea clipboardView = new TextArea();

        AnimationTimer timer = new AnimationTimer() {

            Clipboard systemClipboard = Clipboard.getSystemClipboard();

            @Override
            public void handle(long timestamp) {
                String content = systemClipboard.getString();
                // do anything you need with this, e.g.:
                clipboardView.setText(content);
            }
        };

        timer.start();

        primaryStage.setScene(new Scene(clipboardView, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}