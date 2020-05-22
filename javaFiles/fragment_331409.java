import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication173 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        DieImages images = new DieImages();
        Die die = new Die(images.getImages());
        StackPane stackPane = new StackPane(die.getdieFace());//Add ImageView(Die) to stackPane
        VBox.setVgrow(stackPane, Priority.ALWAYS);

        Button btn = new Button();
        btn.setText("Roll Die");
        btn.setOnAction((ActionEvent event) -> {
            btn.setDisable(true);//Disable Button
            Random random = new Random();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.3), (actionEvent) -> {
                int tempRandom = random.nextInt(6) + 1;
                System.out.println(tempRandom);
                die.setDieFace(tempRandom);
            }));

            timeline.setCycleCount(random.nextInt(20) + 1);
            timeline.play();
            timeline.setOnFinished(actionEvent -> {
                btn.setDisable(false);//Enable Button
            });
        });

        VBox root = new VBox(stackPane, new StackPane(btn));
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}