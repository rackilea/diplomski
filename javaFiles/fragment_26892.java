import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBall extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle ball = new Circle(20, 80, 10);
        ball.setFill(Color.DARKBLUE);
        Pane pane = new Pane(ball);

        AnimationTimer timer = new AnimationTimer() {

            long lastUpdate = 0 ;
            double changeX = 0.1 ;
            double changeY = 0 ;
            double gravity = 10 ;
            double elasticity = 0.95 ;

            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now ;
                    return ;
                }
                long elapsedNanos = now - lastUpdate;
                double elapsedSeconds = elapsedNanos / 1_000_000_000.0 ;
                lastUpdate = now ;
                ball.setCenterX(ball.getCenterX() + changeX);
                if (ball.getCenterY() + changeY + ball.getRadius() >= pane.getHeight()) {
                    changeY = - changeY * elasticity;
                } else {
                    changeY = changeY + gravity * elapsedSeconds ;
                }
                ball.setCenterY(Math.min(ball.getCenterY() + changeY, pane.getHeight() - ball.getRadius()));
            }

        };

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}