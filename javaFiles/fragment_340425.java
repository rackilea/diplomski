import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication343 extends Application
{
    int invaderWidth = 30;
    int invaderHeight = 10;
    int gapBetweenInvaderX = 5;
    int gapBetweenInvaderY = 5;
    int locationTrackerX;
    int locationTrackerY;

    int screenWidth = 300;
    int screenHeight = 400;

    double timeBetweenFrames = .25;

    boolean direction = true;

    Timeline timeline;

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        locationTrackerX = (screenWidth - (invaderWidth * 6 + gapBetweenInvaderX * 5)) / 2;
        locationTrackerY = (screenHeight - (invaderHeight * 6 + gapBetweenInvaderY * 5)) / 7;

        List<Rectangle> invaders = new ArrayList();
        for (int i = 0; i < 36; i++) {
            Rectangle rectangle = new Rectangle(locationTrackerX, locationTrackerY, invaderWidth, invaderHeight);
            rectangle.setFill(Color.YELLOW);
            invaders.add(rectangle);
            System.out.println(locationTrackerX);

            locationTrackerX += invaderWidth + gapBetweenInvaderX;
            if ((i + 1) % 6 == 0) {
                locationTrackerX = (screenWidth / 2) - ((invaderWidth * 6 + gapBetweenInvaderX * 5) / 2);
                locationTrackerY += invaderHeight + gapBetweenInvaderY;
            }
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(timeBetweenFrames), (event) -> {
            //Check to see if invader hits bounds
            Optional<Rectangle> hitRightOptional = invaders.stream().filter(invader -> invader.getBoundsInLocal().getMaxX() >= pane.getWidth()).findFirst();
            Optional<Rectangle> hitLeftOptional = invaders.stream().filter(invader -> invader.getBoundsInLocal().getMinX() <= 0).findFirst();
            //Move invaders
            if (hitRightOptional.isPresent()) {
                invaders.forEach((tempInvader) -> tempInvader.setY(tempInvader.getY() + 10));
                timeline.stop();
                PauseTransition pause = new PauseTransition(Duration.seconds(timeBetweenFrames));
                pause.setOnFinished((pauseEvent) -> {
                    invaders.forEach(invader -> invader.setX(invader.getX() - 10));
                    timeline.play();
                });
                pause.play();

                direction = false;
            }
            else if (hitLeftOptional.isPresent()) {
                invaders.forEach((tempInvader) -> tempInvader.setY(tempInvader.getY() + 10));
                timeline.stop();
                PauseTransition pause = new PauseTransition(Duration.seconds(timeBetweenFrames));
                pause.setOnFinished((pauseEvent) -> {
                    invaders.forEach(invader -> invader.setX(invader.getX() + 10));
                    timeline.play();
                });
                pause.play();

                direction = true;
            }
            else {
                if (direction) {
                    invaders.forEach(invader -> invader.setX(invader.getX() + 10));
                }
                else {
                    invaders.forEach(invader -> invader.setX(invader.getX() - 10));
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        Button btn = new Button();
        btn.setText("Start Game");
        btn.setOnAction((ActionEvent event) -> {
            timeline.play();
            btn.setDisable(true);
        });

        pane.getChildren().addAll(invaders);
        pane.setPrefSize(screenWidth, screenHeight);

        VBox root = new VBox(pane, new StackPane(btn));
        Scene scene = new Scene(root, screenWidth, screenHeight);

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