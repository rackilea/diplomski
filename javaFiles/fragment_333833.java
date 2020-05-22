import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TransparentTextArea extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        StackPane root = new StackPane(textArea);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("transparent-text-area.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}