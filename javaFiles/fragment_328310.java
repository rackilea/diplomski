import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class scene1 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button=new Button("problem");
        Pane pane1=new Pane();
        pane1.setPrefSize(600, 600);
        VBox vbox = new VBox(50);

        vbox.getChildren().addAll(button, pane1);

        //mainScene = new Scene(box, 200, 200);
        Scene sceneNew=new Scene(vbox, 200, 200, Color.AQUAMARINE);
        primaryStage.setScene(sceneNew);
        primaryStage.setTitle("Test Button");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}