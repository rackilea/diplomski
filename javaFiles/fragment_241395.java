import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        var pane = new TitledPane("CONSOLE", new TextArea("This is the console output."));
        pane.setGraphic(new Button("CLEAR"));

        var scene = new Scene(pane, 600, 400);
        scene.getStylesheets().add("Main.css"); // replace with your resource

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}