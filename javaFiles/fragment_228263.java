import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RemoveNodes_Demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setVgap(10);
        pane.setHgap(10);

        Button button1 = new Button("Add Nodes");
        button1.setOnAction(e->{
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400), x -> {
                StackPane sp = new StackPane();
                sp.setMinSize(100,100);
                sp.setStyle("-fx-background-color:black,red;-fx-background-insets:0,2;");
                pane.getChildren().add(sp);
            }));
            timeline.setCycleCount(10);
            timeline.play();
        });

        Button button2 = new Button("Remove Nodes");
        button2.setOnAction(e->{
            if(!pane.getChildren().isEmpty()){
                int count = pane.getChildren().size();
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400), x -> {
                   if(!pane.getChildren().isEmpty()){ 
                      pane.getChildren().remove(0);
                   }
                }));
                timeline.setCycleCount(count);
                timeline.play();
            }
        });
        VBox root = new VBox(button1, button2,pane);
        root.setSpacing(10);
        Scene sc = new Scene(root, 600, 600);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String... a) {
        Application.launch(a);
    }
}