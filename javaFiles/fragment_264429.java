import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UndecoratedStageExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("OK");
        button.setOnAction(event -> primaryStage.close());
        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 250, 80);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}