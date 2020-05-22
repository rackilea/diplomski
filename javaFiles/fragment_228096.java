import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MousePressAndHoldTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        addPressAndHoldHandler(root, Duration.seconds(1), 
                event -> System.out.println("Press and hold"));


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    private void addPressAndHoldHandler(Node node, Duration holdTime, 
            EventHandler<MouseEvent> handler) {

        class Wrapper<T> { T content ; }
        Wrapper<MouseEvent> eventWrapper = new Wrapper<>();

        PauseTransition holdTimer = new PauseTransition(holdTime);
        holdTimer.setOnFinished(event -> handler.handle(eventWrapper.content));


        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            eventWrapper.content = event ;
            holdTimer.playFromStart();
        });
        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> holdTimer.stop());
        node.addEventHandler(MouseEvent.DRAG_DETECTED, event -> holdTimer.stop());
    }


    public static void main(String[] args) {
        launch(args);
    }
}