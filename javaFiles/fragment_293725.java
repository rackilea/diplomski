import java.util.ArrayList;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestMotion extends Application {

    int N = 10;
    static ArrayList<Integer> move = new ArrayList<Integer>();
    private double sceneWidth = 512;
    private double sceneHeight = 512;
    MyNode node = new MyNode(0, 0, 5);
    Group root; //Made root as global variable
    int n = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new Group();

        root.getChildren().addAll(node);

        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        primaryStage.setScene(scene);
        primaryStage.show();

        animate(0.0f, 0.0f, 5.0f, 5.0f); //Passing initial coordinates to the method

    }

    //convention conversion (i,j) to node number x
    public static int convert(int i, int j, int N) {
        return (j * N + i + 1);
    }

    //convention conversion node number x to (i,j)
    //implement in order of definition
    public static int reconvertY(int x, int N) {
        return (int) java.lang.Math.floor((x - 1) / N);
    }

    public static int reconvertX(int x, int N, int j) {
        return (x - j * N - 1);
    }

    private void animate(float moveX, float moveY, float lineX, float lineY) {
        Path pathA = new Path();
        root.getChildren().add(pathA);
        nextPos(move, N);
        int y1 = reconvertY(move.get(move.size() - 1), N);
        int x1 = reconvertX(move.get(move.size() - 1), N, y1);
        //Applying coordinates as obtained
        pathA.getElements().add(new MoveTo(moveX, moveY)); 
        pathA.getElements().add(new LineTo(lineX, lineY));
        pathA.setStroke(Color.RED);
        pathA.setStrokeWidth(1.0);

        PathTransition pathTransitionA = new PathTransition();
        pathTransitionA.setDuration(Duration.millis(100));
        pathTransitionA.setNode(node);
        pathTransitionA.setPath(pathA);

        pathTransitionA.play();

        pathTransitionA.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (pathTransitionA.getStatus() == Status.RUNNING) {
                    return;
                }

                animate(lineX, lineY, lineX + 2, lineY + 2); //previous path's endpoint makes the start point of the new Path
            }
        });

    }

    //allot new node to the arraylist such that it is adjacent to the previously assigned node
    private void nextPos(ArrayList<Integer> array, int N) {
        //I removed this part to save space because it is probably irrelevant the the problem at hand

    }

    public static void main(String[] args) {

        move.add(1);
        launch(args);
    }

    public static class MyNode extends StackPane {

        public MyNode(double x, double y, double r) {

            // create circle
            Circle circle = new Circle();
            circle.setRadius(r);

            circle.setFill(Color.BLUE);

            // set position
            setTranslateX(x);
            setTranslateY(y);

            getChildren().add(circle);

        }

    }

}