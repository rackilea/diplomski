import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UnfocusTextField extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setOnMousePressed(e -> root.requestFocus());
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        for (int i = 0 ; i < 10; i++) {
            root.add(new TextField(), i % 2, i / 2 );
        }
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}