import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EmbeddedSample extends Application {
    @Override public void start(Stage stage) {
        stage.setScene(new Scene(new StackPane(new TextField("xyzzy")), 200, 100));
        stage.getScene().setOnMouseClicked(e -> stage.hide());
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}