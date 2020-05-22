import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SingleModal extends Application {

    @Override
    public void start(Stage primaryStage)  {

        Stage subStage1 = new Stage();
        subStage1.setTitle("New Stage1");

        Button btn2 = new Button("Button: Stage1");
        FlowPane root2 = new FlowPane();
        root2.setAlignment(Pos.CENTER);
        root2.getChildren().add(btn2);
        btn2.setOnAction(eve-> System.out.println("Clicked on Stage 1 Button"));
        subStage1.initOwner(primaryStage);
        subStage1.initModality(Modality.NONE);
        Scene scene1 = new Scene(root2, 300, 200);
        subStage1.setScene(scene1);

        primaryStage.setTitle("PrimaryStage");
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 700, 200);
        Button btn = new Button("Open New Stage");
        btn.setOnAction(eve->  subStage1.show());
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}