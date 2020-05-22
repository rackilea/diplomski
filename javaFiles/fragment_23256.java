import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication124 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {        
        Circle circle2 = new Circle(250, 120, 80);
        circle2.setFill(Color.RED);
        circle2.setStroke(Color.BLACK);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(10);
        fade.setToValue(0.1);
        fade.setCycleCount(1000);
        fade.setAutoReverse(true);
        fade.setNode(circle2);

        Circle circle1 = new Circle(250, 120, 80);
        circle1.setFill(Color.RED);
        circle1.setStroke(Color.BLACK);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(circle1);

        Circle circle3 = new Circle(250, 120, 80);
        circle3.setFill(Color.RED);
        circle3.setStroke(Color.BLACK);
        ScaleTransition scale = new ScaleTransition();
        scale.setByX(25);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(500);
        scale.setAutoReverse(true);
        scale.setNode(circle3);

        ListView listView = new ListView();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->{
            ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
            if(selectedItems.contains("Fade Transition"))
            {
                fade.play();
            }
            else
            {
                fade.jumpTo(Duration.ZERO);
                fade.stop();                
            }

            if(selectedItems.contains("Translate Transition"))
            {
                translate.play();
            }
            else
            {
                translate.jumpTo(Duration.ZERO);
                translate.stop();
            }

            if(selectedItems.contains("Scale Transition"))
            {
                scale.play();
            }
            else
            {
                scale.jumpTo(Duration.ZERO);
                scale.stop();
            }            
        });

        listView.getItems().add("Fade Transition");
        listView.getItems().add("Translate Transition");
        listView.getItems().add("Scale Transition");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(listView, new SubScene(new VBox(circle1, circle2, circle3), 800, 500));

        Scene scene = new Scene(hbox, 1080, 720, Color.WHEAT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
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