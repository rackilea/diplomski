import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PercentageColorPane extends Pane {

    double ratio;

    DoubleBinding widthBinding;

    public PercentageColorPane(double percent) {
        assert 0.0 <= percent && percent <= 100.0;
        ratio = 0.01 * percent;

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.RED);

        widthBinding = widthProperty().multiply(ratio);

        rectangle.setX(0.0);
        rectangle.setY(0.0);
        rectangle.heightProperty().bind(heightProperty());
        rectangle.widthProperty().bind(widthBinding);

        getChildren().add(rectangle);
    }

}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PercentageColorPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PercentageColorPane pane = new PercentageColorPane(30.0);       
        Scene scene = new Scene(pane, 800, 600);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}