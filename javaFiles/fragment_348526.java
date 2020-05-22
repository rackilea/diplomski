import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication368 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Circle cirle = new Circle(50);

        StackPane root = new StackPane(cirle);

        Scene scene = new Scene(root, 300, 250);

        scene.addEventFilter(MouseEvent.DRAG_DETECTED, (MouseEvent mouseEvent) -> {
            scene.startFullDrag();
        });

        cirle.setOnMouseDragEntered(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                System.out.println("slice!");
            }
        });

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