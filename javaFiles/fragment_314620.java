import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication117 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Image image = new Image("http://lmsotfy.com/so.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        //Use this Circle to help see where the rotation occurs
        Circle circle = new Circle(5);
        circle.setFill(Color.RED);
        circle.setCenterX(100);
        circle.setCenterY(300);

        //Add the Rotate to the ImageView's Transforms
        Rotate rotation = new Rotate();
        rotation.setPivotX(circle.getCenterX());//Set the Pivot's X to be the same location as the Circle's X. This is only used to help you see the Pivot's point
        rotation.setPivotY(circle.getCenterY());//Set the Pivot's Y to be the same location as the Circle's Y. This is only used to help you see the Pivot's point
        imageView.getTransforms().add(rotation);//Add the Rotate to the ImageView

        //Use the Button's handler to rotate the ImageView
        btn.setOnAction((ActionEvent event) -> {
            rotation.setAngle(rotation.getAngle() + 15);
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(imageView, circle);
        VBox.setVgrow(pane, Priority.ALWAYS);

        VBox vBox = new VBox(pane, new StackPane(btn));

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 1080, 720);

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